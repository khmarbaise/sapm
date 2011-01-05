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

import java.io.File;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * This test is intended to check how the interface looks like for the user of this.
 *
 * @author Karl Heinz Marbaise
 *
 */
public class AuthorizationFileTest extends TestBase {

    private AuthorizationFile authorizationFile;

    @BeforeMethod
    public void beforeMethod() throws AuthorizationFileException {
        authorizationFile = new AuthorizationFile();
        authorizationFile.load(new File(getFileResource("/svnaccess-groups-in-groups.conf")));
    }

    @DataProvider(name = "createAccessSet")
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
    public void accessRuleCheck(String user, String repository, String accessPath, AccessLevel expectedLevel) {
        // Check the permission of the current user in the repository within the
        // given accessPath
        AccessLevel al_user = authorizationFile.getAccessRules().getAccess(user, repository, accessPath);
        Assert.assertEquals(expectedLevel, al_user);
    }

}
