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
 * c-developer = harry, brian
 * d-developer = michael, sally
 * e-developer = jonas
 * all-developer = &#64;c-developer, &#64;d-developer, &#64;e-developer
 * [/]
 * * = r
 * [repository:/project-c/trunk]
 * &#64;c-developer = rw
 * [repository:/project-d/trunk]
 * &#64;d-developer = rw
 * [repository:/project-e/trunk]
 * &#64;e-developer = rw
 * [global:/project/trunk]
 * &#64;all-developer = rw
 * </pre>
 *
 * The tests will check if the AccessLevel will be extracted correctly and
 * furthermore if the access to different directories inside this repository
 * will work well.
 *
 * Hint: The access rules in this file and the contents of the
 * configuration file svnaccess-groups-in-groups.conf should be the
 * same to have a possibility to compare the results of these two
 * tests.
 * @author Karl Heinz Marbaise
 *
 */
public class AccessRulesGroupGroupTest {

    private AccessRules accessRules = new AccessRules();

    /**
     * This method will define the following rules:
     *
     * <pre>
     * [groups]
     * c-developer = harry, brian
     * d-developer = michael, sally
     * e-developer = jonas
     * all-developer = &#64;c-developer, &#64;d-developer, &#64;e-developer
     * [/]
     * * = r
     * [repository:/project-c/trunk]
     * &#64;c-developer = rw
     * [repository:/project-d/trunk]
     * &#64;d-developer = rw
     * [repository:/project-e/trunk]
     * &#64;e-developer = rw
     * [global:/project/trunk]
     * &#64;all-developer = rw
     * </pre>
     */
    @BeforeMethod
    public void beforeMethod() {
        // &#64;c-developer = harry, brian
        Group c_developer = new Group("c-developer");
        c_developer.add(UserFactory.createInstance("harry"));
        c_developer.add(UserFactory.createInstance("brian"));

        Group d_developer = new Group("d-developer");
        d_developer.add(UserFactory.createInstance("michael"));
        d_developer.add(UserFactory.createInstance("sally"));

        Group e_developer = new Group("e-developer");
        e_developer.add(UserFactory.createInstance("jonas"));

        Group all_developer = new Group("all-developer");
        all_developer.add(c_developer);
        all_developer.add(d_developer);
        all_developer.add(e_developer);

        // [/]
        // * = r
        AccessRule accessRuleRoot = new AccessRule("/");
        accessRuleRoot.add(new Access(UserFactory.createInstance("*"), AccessLevel.READ));

        // [repository:/project-c/trunk]
        // c-developer = rw
        AccessRule accessRuleProjectC = new AccessRule("repository", "/project-c/trunk");
        accessRuleProjectC.add(c_developer, AccessLevel.READ_WRITE);

        // [repository:/project-d/trunk]
        // &#64;d-developer = rw
        AccessRule accessRuleProjectD = new AccessRule("repository", "/project-d/trunk");
        accessRuleProjectD.add(d_developer, AccessLevel.READ_WRITE);

        // [repository:/project-e/trunk]
        // &#64;e-developer = rw
        AccessRule accessRuleProjectE = new AccessRule("repository", "/project-e/trunk");
        accessRuleProjectE.add(e_developer, AccessLevel.READ_WRITE);

        // [global:/project/trunk]
        // &#64;all-developer = rw
        AccessRule accessRuleGlobal = new AccessRule("global", "/project/trunk");
        accessRuleGlobal.add(all_developer, AccessLevel.READ_WRITE);

        accessRules.add(accessRuleRoot);
        accessRules.add(accessRuleProjectC);
        accessRules.add(accessRuleProjectD);
        accessRules.add(accessRuleProjectE);
        accessRules.add(accessRuleGlobal);
    }

    @DataProvider(name = "createAccessSet")
    /**
     * <pre>
     * [groups]
     * c-developer = harry, brian
     * d-developer = michael, sally
     * e-developer = jonas
     * all-developer = &#64;c-developer, &#64;d-developer, &#64;e-developer
     * [/]
     * * = r
     * [repository:/project-c/trunk]
     * &#64;c-developer = rw
     * [repository:/project-d/trunk]
     * &#64;d-developer = rw
     * [repository:/project-e/trunk]
     * &#64;e-developer = rw
     * [global:/project/trunk]
     * &#64;all-developer = rw
     * </pre>
     *
     */
    public Object[][] createAccessSet() {
        return new Object[][] {
            { "harry",      "repository", "/",                          AccessLevel.READ },
            { "brian",      "repository", "/",                          AccessLevel.READ },
            { "micheal",    "repository", "/",                          AccessLevel.READ },
            { "sally",      "repository", "/",                          AccessLevel.READ },
            { "jonas",      "repository", "/",                          AccessLevel.READ },
            { "decon",      "repository", "/",                          AccessLevel.READ },

            { "harry",      "repository", "/project-c/",                AccessLevel.READ },
            { "harry",      "repository", "/project-d/",                AccessLevel.READ },
            { "harry",      "repository", "/project-e/",                AccessLevel.READ },

            { "brian",      "repository", "/project-c/",                AccessLevel.READ },
            { "brian",      "repository", "/project-d/",                AccessLevel.READ },
            { "brian",      "repository", "/project-e/",                AccessLevel.READ },

            { "michael",    "repository", "/project-c/",                AccessLevel.READ },
            { "micheal",    "repository", "/project-d/",                AccessLevel.READ },
            { "micheal",    "repository", "/project-e/",                AccessLevel.READ },

            { "sally",      "repository", "/project-c/",                AccessLevel.READ },
            { "sally",      "repository", "/project-d/",                AccessLevel.READ },
            { "sally",      "repository", "/project-e/",                AccessLevel.READ },

            { "jonas",      "repository", "/project-c/",                AccessLevel.READ },
            { "jonas",      "repository", "/project-d/",                AccessLevel.READ },
            { "jonas",      "repository", "/project-e/",                AccessLevel.READ },

            { "decon",      "repository", "/project-c/",                AccessLevel.READ },
            { "decon",      "repository", "/project-d/",                AccessLevel.READ },
            { "decon",      "repository", "/project-e/",                AccessLevel.READ },

            { "harry",      "repository", "/project-c/trunk/",          AccessLevel.READ_WRITE },
            { "brian",      "repository", "/project-c/trunk/",          AccessLevel.READ_WRITE },
            { "micheal",    "repository", "/project-c/trunk/",          AccessLevel.READ },
            { "sally",      "repository", "/project-c/trunk/",          AccessLevel.READ },
            { "jonas",      "repository", "/project-c/trunk/",          AccessLevel.READ },
            { "decon",      "repository", "/project-c/trunk/",          AccessLevel.READ },

            { "harry",      "repository", "/project-d/trunk/",          AccessLevel.READ },
            { "brian",      "repository", "/project-d/trunk/",          AccessLevel.READ },
            { "michael",    "repository", "/project-d/trunk/",          AccessLevel.READ_WRITE },
            { "sally",      "repository", "/project-d/trunk/",          AccessLevel.READ_WRITE },
            { "jonas",      "repository", "/project-d/trunk/",          AccessLevel.READ },
            { "decon",      "repository", "/project-d/trunk/",          AccessLevel.READ },

            { "harry",      "repository", "/project-e/trunk/",          AccessLevel.READ },
            { "brian",      "repository", "/project-e/trunk/",          AccessLevel.READ },
            { "michael",    "repository", "/project-e/trunk/",          AccessLevel.READ },
            { "sally",      "repository", "/project-e/trunk/",          AccessLevel.READ },
            { "jonas",      "repository", "/project-e/trunk/",          AccessLevel.READ_WRITE },
            { "decon",      "repository", "/project-e/trunk/",          AccessLevel.READ },

            { "harry",      "global",     "/project/trunk/",            AccessLevel.READ_WRITE },
            { "brian",      "global",     "/project/trunk/",            AccessLevel.READ_WRITE },
            { "michael",    "global",     "/project/trunk/",            AccessLevel.READ_WRITE },
            { "sally",      "global",     "/project/trunk/",            AccessLevel.READ_WRITE },
            { "jonas",      "global",     "/project/trunk/",            AccessLevel.READ_WRITE },
            { "decon",      "global",     "/project/trunk/",            AccessLevel.READ },

            { "harry",      "global",     "/project/",                  AccessLevel.READ },
            { "brian",      "global",     "/project/",                  AccessLevel.READ },
            { "michael",    "global",     "/project/",                  AccessLevel.READ },
            { "sally",      "global",     "/project/",                  AccessLevel.READ },
            { "jonas",      "global",     "/project/",                  AccessLevel.READ },
            { "decon",      "global",     "/project/",                  AccessLevel.READ },

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
