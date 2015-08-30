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

package org.apache.hadoop.yarn.server.api.records.impl.pb;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.hadoop.yarn.proto.YarnServerCommonProtos.InMemoryBlockProto;
import org.apache.hadoop.yarn.proto.YarnServerCommonProtos.InMemoryBlockProtoOrBuilder;
import org.apache.hadoop.yarn.server.api.records.InMemoryBlock;
import org.apache.hadoop.yarn.server.api.records.NodeHealthStatus;
import org.apache.hadoop.yarn.server.api.records.NodeStatus;
    

public class InMemoryBlockPBImpl extends InMemoryBlock {
  InMemoryBlockProto proto = InMemoryBlockProto.getDefaultInstance();
  InMemoryBlockProto.Builder builder = null;
  boolean viaProto = false;
  
  private String blockId = null;
  private int numberOfPages = 0;
  
  public InMemoryBlockPBImpl() {
    builder = InMemoryBlockProto.newBuilder();
  }

  public InMemoryBlockPBImpl(InMemoryBlockProto proto) {
    this.proto = proto;
    viaProto = true;
  }
  
  public synchronized InMemoryBlockProto getProto() {
    mergeLocalToProto();
    proto = viaProto ? proto : builder.build();
    viaProto = true;
    return proto;
  }

  private synchronized void mergeLocalToBuilder() {
    if (this.blockId != null) {
      builder.setBlockId(this.blockId);
    }
    if (this.numberOfPages != 0) {
    	builder.setNumberOfPages(this.numberOfPages);
    }
  }

  private synchronized void mergeLocalToProto() {
    if (viaProto) 
      maybeInitBuilder();
    mergeLocalToBuilder();
    proto = builder.build();
    
    viaProto = true;
  }

  private synchronized void maybeInitBuilder() {
    if (viaProto || builder == null) {
      builder = InMemoryBlockProto.newBuilder(proto);
    }
    viaProto = false;
  }
    
 

  @Override
  public int hashCode() {
    return getProto().hashCode();
  }
  
  @Override
  public boolean equals(Object other) {
    if (other == null)
      return false;
    if (other.getClass().isAssignableFrom(this.getClass())) {
      return this.getProto().equals(this.getClass().cast(other).getProto());
    }
    return false;
  }

  @Override
  public String getBlockId() {
    return this.blockId;
  }

  @Override
  public int getNumberOfPages() {
    return this.numberOfPages;
  }

  @Override
  public void setBlockId(String blockId) {
    this.blockId = blockId;
  }

  @Override
  public void setNumberOfPages(int numberOfPages) {
    this.numberOfPages = numberOfPages;
  }
}
