/*
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
 *
 */
#pragma once

#include <folly/io/async/AsyncTransport.h>
#include "hbase/connection/pipeline.h"

namespace hbase {

template <typename T>
class RpcFaultInjector {
 public:
  RpcFaultInjector();
  virtual ~RpcFaultInjector();

  static std::shared_ptr<T> Get();
  static void Set(std::shared_ptr<T> instance);

 private:
  static std::shared_ptr<T> instance;
};

class RpcClientFaultInjector : public RpcFaultInjector<RpcClientFaultInjector> {
 public:
  RpcClientFaultInjector() {}
  virtual ~RpcClientFaultInjector() {}
  /**
   * Here goes virtual functions for injecting various faults. They should be no-ops by default.
   * Sub classes of RpcClientFaultInjector will override by providing concrete faults.
   */
};
} /* namespace hbase */

#include "hbase/connection/rpc-fault-injector-inl.h"
