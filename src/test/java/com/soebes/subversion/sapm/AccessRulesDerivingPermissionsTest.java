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

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * This test will check if the given users and group members
 * do have the correct access permissions within the different
 * folders and/or repositories.
 *
 * <pre>
 * [groups]
 * developer = harry, brian
 * admin = micheal
 * [/]
 * * =
 * [repository:/test/trunk]
 * &#64;developer = r
 * &#64;admin = rw
 * </pre>
 *
 * The tests will check if the AccessLevel will be extracted correctly and
 * furthermore if the access to different directories inside this repository
 * will work well.
 *
 * @author Karl Heinz Marbaise
 *
 */
public class AccessRulesDerivingPermissionsTest {

    private AccessRules accessRules;
    private AccessRule accessRule;
    /**
     * This will setup the following set of rules.
     *
     * <pre>
     * [groups]
     * developer = harry, brian
     * admin = micheal
     * [/]
     * * =
     * [repository:/test/trunk]
     * &#64;developer = r
     * &#64;admin = rw
     * </pre>
     */
    @BeforeMethod
    public void beforeMethod() {

        // &#64;developer = harry, brian
        User userHarry = UserFactory.createInstance("harry");
        User userBrian = UserFactory.createInstance("brian");
        Group developerGroup = new Group("developer");
        developerGroup.add(userHarry);
        developerGroup.add(userBrian);


        // &#64;admin = michael
        Group adminGroup = new Group("admin");
        User userMicheal = UserFactory.createInstance("michael");
        adminGroup.add(userMicheal);

        // [/]
        // * =
        User userAsterik = UserFactory.createInstance("*");
        AccessRule accessRuleRoot = new AccessRule("/");
        accessRuleRoot.add(userAsterik, AccessLevel.NOTHING);

        // [repository:/test/trunk]
        // &#64;developer = r
        // &#64;admin = rw
        accessRule = new AccessRule("repository", "/test/trunk");
        accessRule.add(developerGroup, AccessLevel.READ);
        accessRule.add(adminGroup, AccessLevel.READ_WRITE);

        accessRules = new AccessRules();
        accessRules.add(accessRuleRoot);
        accessRules.add(accessRule);
    }

    @Test
    public void accessTest() {
        AccessLevel al_harry = accessRule.getAccessForPrincipal("harry");
        Assert.assertEquals(AccessLevel.READ, al_harry);

        AccessLevel al_brian = accessRule.getAccessForPrincipal("brian");
        Assert.assertEquals(AccessLevel.READ, al_brian);

        AccessLevel al_hugo = accessRule.getAccessForPrincipal("hugo");
        Assert.assertEquals(AccessLevel.NOTHING, al_hugo);

        AccessLevel al_micheal = accessRule.getAccessForPrincipal("michael");
        Assert.assertEquals(AccessLevel.READ_WRITE, al_micheal);
    }

    @DataProvider(name = "createAccessSet")
    public Object[][] createAccessSet() {
        return new Object[][] {
            { "harry",      "repository", "/",                          AccessLevel.NOTHING },
            { "michael",    "repository", "/test/",                     AccessLevel.NOTHING },
            { "brian",      "repository", "/test/",                     AccessLevel.NOTHING },

            { "sally",      "repository", "/test/trunk/src/xyz.java",   AccessLevel.NOTHING }, //Unknown user
            { "sally",      "repository", "/test/trunk/",               AccessLevel.NOTHING }, //Unknown user
            { "harry",      "different", "/test/trunk/",                AccessLevel.NOTHING }, //different repository
            { "michael",    "different", "/test/trunk/",                AccessLevel.NOTHING }, //different repository
            { "brian",      "different", "/test/trunk/",                AccessLevel.NOTHING }, //different repository

            { "harry",      "repository", "/test/trunk/",               AccessLevel.READ },
            { "harry",      "repository", "/test/trunk/src/",           AccessLevel.READ },
            { "harry",      "repository", "/test/trunk/src/xyz.java",   AccessLevel.READ },
            { "harry",      "repository", "/test/trunk/src/CHANGELOG",  AccessLevel.READ },

            { "brian",      "repository", "/test/",                     AccessLevel.NOTHING },
            { "brian",      "repository", "/test/trunk/",               AccessLevel.READ },
            { "brian",      "repository", "/test/trunk/src/xyz.java",   AccessLevel.READ },
            { "brian",      "repository", "/test/trunk/src/CHANGELOG",  AccessLevel.READ },

            { "michael",    "repository", "/test/trunk/",               AccessLevel.READ_WRITE },
            { "michael",    "repository", "/test/trunk/",               AccessLevel.READ_WRITE },
            { "michael",    "repository", "/test/trunk/src/",           AccessLevel.READ_WRITE },
            { "michael",    "repository", "/test/trunk/src/xyz.java",   AccessLevel.READ_WRITE },
            { "michael",    "repository", "/test/trunk/src/CHANGELOG",  AccessLevel.READ_WRITE },

            { "michael",    "repository", "/test/trunk/src/xyz.java",   AccessLevel.READ_WRITE },
            { "michael",    "repository", "/test/trunk/src/CHANGELOG",  AccessLevel.READ_WRITE }, };
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
