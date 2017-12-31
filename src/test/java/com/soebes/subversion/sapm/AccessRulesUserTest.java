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


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * This test will create AccessRules as follows:
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
public class AccessRulesUserTest {

    private AccessRules accessRules;

    /**
     * This method will define the following rule:
     *
     */
    @BeforeMethod
    public void beforeMethod() {
        accessRules = new AccessRules();

        User userAsterik = UserFactory.createInstance("*");
        AccessRule accessRuleRoot = new AccessRule("/");
        accessRuleRoot.add(userAsterik, AccessLevel.READ);
        accessRules.add(accessRuleRoot);

        User userHarry = UserFactory.createInstance("harry");
        User userMicheal = UserFactory.createInstance("michael");

        AccessRule accessRule = new AccessRule("repository", "/test/trunk");
        accessRule.add(userHarry, AccessLevel.READ_WRITE);
        accessRule.add(userMicheal, AccessLevel.READ_WRITE);
        accessRules.add(accessRule);

    }

    @DataProvider(name = "createAccessSet")
    public Object[][] createAccessSet() {
        return new Object[][] {
            { "harry",      "repository",    "/",                            AccessLevel.READ },
            { "harry",      "repository",    "/test/trunk/",                 AccessLevel.READ_WRITE },
            { "harry",      "repository",    "/test/trunk/src/",             AccessLevel.READ_WRITE },
            { "harry",      "repository",    "/test/trunk/src/xyz.java",     AccessLevel.READ_WRITE },
            { "harry",      "repository",    "/test/trunk/src/CHANGELOG",    AccessLevel.READ_WRITE },

            { "michael",    "repository",    "/test/trunk/",                 AccessLevel.READ_WRITE },
            { "michael",    "repository",    "/test/trunk/src/",             AccessLevel.READ_WRITE },

            { "brian",      "repository",    "/test/trunk/src/xyz.java",     AccessLevel.READ },
            { "brian",      "repository",    "/test/trunk/src/CHANGELOG",    AccessLevel.READ },
            { "sally",      "repository",    "/test/trunk/src/xyz.java",     AccessLevel.READ },
            { "brian",      "repository",    "/test/trunk/",                 AccessLevel.READ },
            { "sally",      "repository",    "/test/trunk/",                 AccessLevel.READ },
            { "harry",      "different",     "/test/trunk/",                 AccessLevel.READ },
            { "michale",    "different",     "/test/",                       AccessLevel.READ },
        };
    }

    @Test(dataProvider = "createAccessSet")
    public void accessRuleCheck(String user, String repository,
            String accessPath, AccessLevel expectedLevel) {
        // Check the permission of the current user in the repository within the
        // given accessPath
        AccessLevel al_user = accessRules.getAccess(user, repository, accessPath);
        Assert.assertEquals(expectedLevel, al_user);
    }

}
