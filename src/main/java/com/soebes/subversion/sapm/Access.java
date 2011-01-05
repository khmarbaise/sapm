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
 * This represents the {@link AccessLevel access level} plus the user/group for which
 * this permission should be defined.
 * @author Karl Heinz Marbaise
 *
 */
public class Access {

    private IPrincipal principal;
    private AccessLevel level;

    public Access() {
        setPrincipal(null);
        setLevel(AccessLevel.NOTHING);
    }

    /**
     * Create a new instance with the given parameters.
     * @param principal Either a {@link User} or a {@link Group}.
     * @param level The level for the access.
     */
    public Access(IPrincipal principal, AccessLevel level) {
        super();
        setPrincipal(principal);
        setLevel(level);
    }

    public IPrincipal getPrincipal() {
        return principal;
    }

    public void setPrincipal(IPrincipal principal) {
        this.principal = principal;
    }

    public AccessLevel getLevel() {
        return level;
    }

    public void setLevel(AccessLevel level) {
        this.level = level;
    }
}
