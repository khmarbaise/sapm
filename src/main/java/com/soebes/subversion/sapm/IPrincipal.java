/**
 * The Subversion Authentication Parse Module (SAPM for short).
 *
 * Copyright (c) 2010, 2011 by SoftwareEntwicklung Beratung Schulung (SoEBeS)
 * Copyright (c) 2010, 2011 by Karl Heinz Marbaise
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.soebes.subversion.sapm;

/**
 * This represents either a {@link User} or a {@link Group} or an
 * {@link Alias}.
 *
 * @author Karl Heinz Marbaise
 *
 */
public interface IPrincipal {

    String getName();

    void setName(String name);

    /**
     * Will check to see if the given name is contained
     * in the group if the instance represents a {@link Group}
     * or if the given name is the same if the instance
     * represents a single {@link User}.
     * @param name The name we check for.
     * @return true if the name is the same or contained false otherwise.
     */
    boolean contains(String name);
}
