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

import java.util.ArrayList;

public class Group implements IPrincipal {

    private ArrayList<IPrincipal> principalList;

    private String name;

    private void init() {
        setPrincipalList(new ArrayList<IPrincipal>());
    }

    public Group() {
        init();
    }

    public Group(String name) {
        setName(name);
        init();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(IPrincipal principal) {
        if (!getPrincipalList().contains(principal)) {
            getPrincipalList().add(principal);
        }
    }

    public boolean contains(User user) {
        return contains(user.getName());
    }

    public boolean contains(String user) {
        boolean result = false;
        for (IPrincipal item : getPrincipalList()) {
            if (item.contains(user)) {
                result = true;
            }
        }
        return result;
    }

    public ArrayList<IPrincipal> getPrincipalList() {
        return principalList;
    }

    public void setPrincipalList(ArrayList<IPrincipal> principalList) {
        this.principalList = principalList;
    }

}
