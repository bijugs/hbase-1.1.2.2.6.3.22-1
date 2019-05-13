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

#include <wangle/channel/Handler.h>

#include "hbase/connection/request.h"
#include "hbase/connection/response.h"
#include "hbase/serde/rpc-serde.h"

using namespace hbase;

namespace hbase {
// A real rpc server would probably use generated client/server stubs
class RpcTestServerSerializeHandler
    : public wangle::Handler<std::unique_ptr<folly::IOBuf>, std::unique_ptr<Request>,
                             std::unique_ptr<Response>, std::unique_ptr<folly::IOBuf>> {
 public:
  RpcTestServerSerializeHandler() : serde_() {}

  void read(Context* ctx, std::unique_ptr<folly::IOBuf> buf) override;

  folly::Future<folly::Unit> write(Context* ctx, std::unique_ptr<Response> resp) override;

 private:
  std::unique_ptr<Request> CreateReceivedRequest(const std::string& method_name);

 private:
  hbase::RpcSerde serde_;
};
}  // end of namespace hbase
