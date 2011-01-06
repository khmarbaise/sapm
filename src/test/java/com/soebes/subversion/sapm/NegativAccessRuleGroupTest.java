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
 * This test will create an AccessRule as follows:
 *
 * <pre>
 * [groups]
 * developer = harry, brian
 *
 * [repository:/test/trunk]
 * ~&#64;developer = r
 * harry = rw
 * </pre>
 *
 * This test will check if harry inside the repository in /test/trunk has RW
 * and outside NOTHING.
 * Any other user has to be having NOTHING but hte users brian must have
 * READ in repository and path /test/trunk.
 *
 * @author Karl Heinz Marbaise
 *
 */
public class NegativAccessRuleGroupTest {

    private AccessRule accessRule;

    /**
     * This method will define the following rule:
     *
     * <pre>
     * [groups]
     * developer = harry, brian
     *
     * [repository:/test/trunk]
     * ~&#64;developer = r
     * harry = rw
     * </pre>
     */
    @BeforeMethod
    public void beforeMethod() {
        User userHarry = UserFactory.createInstance("harry");
        User userBrian = UserFactory.createInstance("brian");

        Group developerGroup = new Group("developer");

        // @developer = harry, brian
        developerGroup.add(userHarry);
        developerGroup.add(userBrian);

        // [repository:/test/trunk]
        // ~@developer = r
        // harry = rw
        accessRule = new AccessRule("repository", "/test/trunk");
        accessRule.addNegative(developerGroup, AccessLevel.READ);
        accessRule.add(userHarry, AccessLevel.READ_WRITE);
    }

    @Test
    public void accessTest() {
        AccessLevel al_harry = accessRule.getAccessForPrincipal("harry");
        Assert.assertEquals(AccessLevel.READ_WRITE, al_harry);

        AccessLevel al_brian = accessRule.getAccessForPrincipal("brian");
        Assert.assertEquals(AccessLevel.NOTHING, al_brian);

        AccessLevel al_hugo = accessRule.getAccessForPrincipal("hugo");
        Assert.assertEquals(AccessLevel.READ, al_hugo);

    }

    @DataProvider(name = "createAccessSet")
    public Object[][] createAccessSet() {
        return new Object[][] {
            { "harry",      "repository", "/",                          AccessLevel.NOTHING },
            { "harry",      "repository", "/test/trunk/",               AccessLevel.READ_WRITE },
            { "harry",      "repository", "/test/trunk/src/",           AccessLevel.READ_WRITE },

            { "brian",      "repository", "/test/trunk/",               AccessLevel.NOTHING },
            { "brian",      "repository", "/test/trunk/src/CHANGELOG",  AccessLevel.NOTHING },

            { "sally",      "repository", "/test/trunk/src/xyz.java",   AccessLevel.READ },
            { "sally",      "repository", "/test/trunk/",               AccessLevel.READ },

            { "michael",    "repository", "/test/trunk/src/xyz.java",   AccessLevel.READ },
            { "michael",    "repository", "/test/trunk/",               AccessLevel.READ },

            { "harry",      "different", "/test/trunk/",                AccessLevel.NOTHING },
            { "michael",    "different", "/test/trunk/",                AccessLevel.NOTHING },
            { "brian",      "different", "/test/trunk/",                AccessLevel.NOTHING },

        };
    }

    @Test(dataProvider = "createAccessSet")
    public void accessRuleCheck(String user, String repository, String accessPath, AccessLevel expectedLevel) {
        AccessLevel al_user = accessRule.getAccess(user, repository, accessPath);
        Assert.assertEquals(expectedLevel, al_user);
    }

}
