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
package org.apache.hadoop.yarn.server.api.records;

import org.apache.hadoop.yarn.util.Records;


public abstract class InMemoryBlock {
  
  public static InMemoryBlock newInstance(String blockId, int numberOfPages)
  {
	  InMemoryBlock blk = Records.newRecord(InMemoryBlock.class);;
	  blk.setBlockId(blockId);
	  blk.setNumberOfPages(numberOfPages);
	  
    return blk;
  }

  public abstract String getBlockId();
  public abstract int getNumberOfPages();
  
  public abstract void setBlockId(String blockId);
  public abstract void setNumberOfPages(int numberOfPages);
}
