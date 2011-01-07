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

public class Aliases {

    private ArrayList<Alias> aliasesList;

    public Aliases() {
        setAliasesList(new ArrayList<Alias>());
    }

    public void add(Alias alias) {
        getAliasesList().add(alias);
    }

    public boolean hasAlias(String aliasName) {
        boolean result = false;

        for (Alias item : getAliasesList()) {
            if (item.getName().equals(aliasName)) {
                result = true;
            }
        }
        return result;
    }

    public void setAliasesList(ArrayList<Alias> aliasesList) {
        this.aliasesList = aliasesList;
    }

    public ArrayList<Alias> getAliasesList() {
        return aliasesList;
    }

    public Alias getAlias(String aliasName) {
        Alias result = null;
        for (Alias item : getAliasesList()) {
            if (item.getName().equals(aliasName)) {
                result = item;
            }
        }
        return result;
    }

}
