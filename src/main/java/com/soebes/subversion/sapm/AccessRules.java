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
import java.util.List;

/**
 * This class can handle an access rule which comprises of multiple
 * {@link AccessRule}.
 * 
 * <pre>
 * [/]
 * * = r
 * 
 * [repository:/test/trunk]
 * harry = rw
 * michael = rw
 * </pre>
 * 
 * @author Karl Heinz Marbaise
 * 
 */
public class AccessRules {

    private List<AccessRule> accessRules;

    public AccessRules() {
        setAccessRules(new ArrayList<AccessRule>());
    }

    /**
     * Add an {@link AccessRule} to the list of access rules.
     * 
     * @param accessRule
     *            The access rule which will be added.
     */
    public void add(AccessRule accessRule) {
        getAccessRules().add(accessRule);
    }

    /**
     * Get the complete list of access rules.
     * 
     * @return The list of access rules.
     */
    public List<AccessRule> getAccessRules() {
        return accessRules;
    }

    public void setAccessRules(List<AccessRule> accessRules) {
        this.accessRules = accessRules;
    }

    public AccessLevel getAccess(String user, String repository, String accessPath) {
        AccessLevel result = AccessLevel.NOTHING;
        for (AccessRule item : getAccessRules()) {
            AccessLevel itemResult = item.getAccess(user, repository, accessPath);
            if (!itemResult.equals(AccessLevel.NOTHING)) {
                result = itemResult;
            }
        }
        return result;
    }

    public static class UserBuilder {
        private List<User> userList;
        private AccessRule accessRule;
        private Builder builder;

        private UserBuilder(Builder builder, AccessRule accessRule) {
            this.userList = new ArrayList<User>();
            this.builder = builder;
            this.accessRule = accessRule;
        }

        public UserBuilder and(String userName) {
            this.userList.add(UserFactory.createInstance(userName));
            return this;
        }

        public Builder with(AccessLevel level) {
            for (User user : this.userList) {
                accessRule.add(user, level);
            }
            return this.builder;
        }
    }

    public static class AccessRuleBuilder {
        private Builder builder;
        private AccessRule rule;

        private AccessRuleBuilder(Builder builder, AccessRule rule) {
            this.builder = builder;
            this.rule = rule;
        }

        public UserBuilder forUser(String userName) {
            return new UserBuilder(this.builder, rule).and(userName);
        }

    }

    public static class Builder {
        private AccessRules accessRules;

        public Builder() {
            this.accessRules = new AccessRules();
        }

        public AccessRuleBuilder forRepository(String repositoryPath) {
            AccessRule accessRule = new AccessRule(repositoryPath);
            accessRules.add(accessRule);
            return new AccessRuleBuilder(this, accessRule);
        }

        public AccessRules build() {
            return this.accessRules;
        }
    }
}
