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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.Assert;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.soebes.subversion.sapm.parser.SAFPLexer;
import com.soebes.subversion.sapm.parser.SAFPParser;

/**
 * This test will create access rules which are read from
 * configuration file (svnaccess-groups-in-groups.conf) and
 * the same as already defined in the
 * {@link AccessRulesGroupGroupTest} file.
 * This will make sure that the object tree which
 * has been read via the parser is the same as it would be
 * if it had been created manually as in {@link AccessRulesGroupGroupTest}.
 *
 * The following rules are read from the configuration file
 * (svnaccess-groups-in-groups.conf).
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
 * @author Karl Heinz Marbaise
 *
 */
public class AccessRulesGroupGroupFromConfigFileTest extends TestBase {

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
     *
     */
    @BeforeMethod
    public void beforeMethod() throws org.antlr.runtime.RecognitionException, FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(
                getFileResource("/svnaccess-groups-in-groups.conf"));
        ANTLRInputStream stream = new ANTLRInputStream(fis);
        SAFPLexer lexer = new SAFPLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SAFPParser parser = new SAFPParser(tokens);
        parser.prog();
        accessRules = parser.getAccessRules();
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
