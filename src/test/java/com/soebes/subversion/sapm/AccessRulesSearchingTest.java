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

import static org.fest.assertions.api.Assertions.assertThat;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Karl Heinz Marbaise
 *
 */
public class AccessRulesSearchingTest {

    private AccessRules accessRules;

    @BeforeMethod
    public void beforeMethod() {
        accessRules = new AccessRules();

        accessRules.add(createAccessRuleOne());
        accessRules.add(createAccessRuleTwo());
    }

    private AccessRule createAccessRuleOne() {
        User userHarry = UserFactory.createInstance("harry");
        User userBrian = UserFactory.createInstance("brian");
        User userMicheal = UserFactory.createInstance("michael");

        AccessRule accessRule = new AccessRule("/test/trunk");

        accessRule.add(userHarry, AccessLevel.READ_WRITE);
        accessRule.add(userBrian, AccessLevel.READ);
        accessRule.add(userMicheal, AccessLevel.READ_WRITE);
        return accessRule;
    }
    
    private AccessRule createAccessRuleTwo() {
        AccessRule accessRule = new AccessRule("/");
        
        accessRule.add(UserFactory.createInstance("hoby"), AccessLevel.READ);
        return accessRule;
    }

    @Test
    public void accessTest() {
        AccessRule accessRule = new AccessRule("/");
        boolean result = accessRules.getAccessRules().contains(accessRule);
        
        assertThat(result).isTrue();
    }

}
