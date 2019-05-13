/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hbase.chaos.util;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HConstants;
import org.apache.hadoop.hbase.IntegrationTestingUtility;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.chaos.factories.MonkeyFactory;
import org.apache.hadoop.hbase.chaos.monkies.ChaosMonkey;
import org.apache.hadoop.hbase.util.AbstractHBaseTool;
import org.apache.hadoop.util.ToolRunner;

import com.google.common.collect.Sets;

public class ChaosMonkeyRunner extends AbstractHBaseTool {
  private static final Log LOG = LogFactory.getLog(ChaosMonkeyRunner.class);

  public static final String MONKEY_LONG_OPT = "monkey";
  public static final String CHAOS_MONKEY_PROPS = "monkeyProps";
  public static final String TABLE_NAME_OPT = "tableName";
  public static final String FAMILY_NAME_OPT = "familyName";

  private static ChaosMonkeyRunner runner;

  protected IntegrationTestingUtility util;
  protected ChaosMonkey monkey;
  protected String monkeyToUse;
  protected Properties monkeyProps;
  protected boolean noClusterCleanUp = false;
  private String tableName = "ChaosMonkeyRunner.tableName";
  private String familyName = "ChaosMonkeyRunner.familyName";
  private volatile boolean stop = false;

  @Override
  public void addOptions() {
    addOptWithArg("m", MONKEY_LONG_OPT, "Which chaos monkey to run");
    addOptWithArg(CHAOS_MONKEY_PROPS, "The properties file for specifying chaos "
        + "monkey properties.");
    addOptWithArg(TABLE_NAME_OPT, "Table name in the test to run chaos monkey against");
    addOptWithArg(FAMILY_NAME_OPT, "Family name in the test to run chaos monkey against");
  }

  @Override
  protected void processOptions(CommandLine cmd) {
    if (cmd.hasOption(MONKEY_LONG_OPT)) {
      monkeyToUse = cmd.getOptionValue(MONKEY_LONG_OPT);
    }
    monkeyProps = new Properties();
    if (cmd.hasOption(CHAOS_MONKEY_PROPS)) {
      String chaosMonkeyPropsFile = cmd.getOptionValue(CHAOS_MONKEY_PROPS);
      if (StringUtils.isNotEmpty(chaosMonkeyPropsFile)) {
        try {
          monkeyProps.load(this.getClass().getClassLoader()
              .getResourceAsStream(chaosMonkeyPropsFile));
        } catch (IOException e) {
          LOG.warn(e);
          System.exit(EXIT_FAILURE);
        }
      }
    }
    if (cmd.hasOption(TABLE_NAME_OPT)) {
      this.tableName = cmd.getOptionValue(TABLE_NAME_OPT);
    }
    if (cmd.hasOption(FAMILY_NAME_OPT)) {
      this.familyName = cmd.getOptionValue(FAMILY_NAME_OPT);
    }
  }

  @Override
  protected int doWork() throws Exception {
    setUpCluster();
    getAndStartMonkey();
    while (!stop) {// loop here until got killed
      Thread.sleep(10000);
    }
    return 0;
  }

  public static void stopRunner() {
    runner.stop = true;
  }

  public void setUpCluster() throws Exception {
    util = getTestingUtil(getConf());
    boolean isDistributed = isDistributedCluster(getConf());
    if (isDistributed) {
      util.createDistributedHBaseCluster();
      util.checkNodeCount(1);// make sure there's at least 1 alive rs
    } else {
      throw new RuntimeException("ChaosMonkeyRunner must run againt a distributed cluster,"
          + " please check and point to the right configuration dir");
    }
    this.setConf(util.getConfiguration());
  }

  private boolean isDistributedCluster(Configuration conf) {
    return conf.getBoolean(HConstants.CLUSTER_DISTRIBUTED, false);
  }

  public void getAndStartMonkey() throws Exception {
    util = getTestingUtil(getConf());
    MonkeyFactory fact = MonkeyFactory.getFactory(monkeyToUse);
    if (fact == null) {
      fact = getDefaultMonkeyFactory();
    }
    monkey =
        fact.setUtil(util).setTableName(getTablename()).setProperties(monkeyProps)
            .setColumnFamilies(getColumnFamilies()).build();
    monkey.start();
  }

  protected IntegrationTestingUtility getTestingUtil(Configuration conf) {
    if (this.util == null) {
      if (conf == null) {
        this.util = new IntegrationTestingUtility();
        this.setConf(util.getConfiguration());
      } else {
        this.util = new IntegrationTestingUtility(conf);
      }
    }
    return util;
  }

  protected MonkeyFactory getDefaultMonkeyFactory() {
    // Run with slow deterministic monkey by default
    return MonkeyFactory.getFactory(MonkeyFactory.SLOW_DETERMINISTIC);
  }

  public TableName getTablename() {
    return TableName.valueOf(tableName);
  }

  protected Set<String> getColumnFamilies() {
    return Sets.newHashSet(familyName);
  }

  /*
   * If caller wants to add config parameters contained in a file, the path of conf file
   * can be passed as the first two arguments like this:
   *   -c <path-to-conf>
   */
  public static void main(String[] args) throws Exception {
    Configuration conf = HBaseConfiguration.create();
    String[] actualArgs = args;
    if (args.length > 0 && "-c".equals(args[0])) {
      int argCount = args.length - 2;
      if (argCount < 0) {
        throw new IllegalArgumentException("Missing path for -c parameter");
      }
      // load the resource specified by the second parameter
      conf.addResource(args[1]);
      actualArgs = new String[argCount];
      System.arraycopy(args, 2, actualArgs, 0, argCount);
    }
    IntegrationTestingUtility.setUseDistributedCluster(conf);
    runner = new ChaosMonkeyRunner();
    int ret = ToolRunner.run(conf, runner, actualArgs);
    System.exit(ret);
  }

}
