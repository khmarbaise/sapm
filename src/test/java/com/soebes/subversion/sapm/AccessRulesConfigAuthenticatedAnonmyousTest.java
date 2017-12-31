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

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.soebes.subversion.sapm.parser.SAFPLexer;
import com.soebes.subversion.sapm.parser.SAFPParser;

/**
 * @author Karl Heinz Marbaise
 *
 */
public class AccessRulesConfigAuthenticatedAnonmyousTest extends TestBase {

    private AccessRules accessRules = new AccessRules();

    /**
     */
    @BeforeMethod
    public void beforeMethod() throws org.antlr.runtime.RecognitionException, FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(
                getFileResource("/svnaccess-authenticated-anonmyous.conf"));
        ANTLRInputStream stream = new ANTLRInputStream(fis);
        SAFPLexer lexer = new SAFPLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SAFPParser parser = new SAFPParser(tokens);
        parser.prog();
        accessRules = parser.getAccessRules();
    }

    @DataProvider(name = "createAccessSet")
    /**
     */
    public Object[][] createAccessSet() {
        return new Object[][] {
            { "harry",      "repository", "/",         AccessLevel.NOTHING },
            { "brian",      "repository", "/",         AccessLevel.NOTHING },
            { "micheal",    "repository", "/",         AccessLevel.NOTHING },
            { "sally",      "repository", "/",         AccessLevel.NOTHING },
            { "joe",        "repository", "/",         AccessLevel.NOTHING },
            { "decon",      "repository", "/",         AccessLevel.NOTHING },

            { "harry",      "calc", "/",               AccessLevel.NOTHING },
            { "brian",      "calc", "/",               AccessLevel.NOTHING },
            { "micheal",    "calc", "/",               AccessLevel.NOTHING },
            { "sally",      "calc", "/",               AccessLevel.NOTHING },
            { "joe",        "calc", "/",               AccessLevel.NOTHING },
            { "decon",      "calc", "/",               AccessLevel.NOTHING },

            // authenticated
            { "harry",      "calc", "/project-c/",     AccessLevel.READ_WRITE },
            { "brian",      "calc", "/project-c/",     AccessLevel.READ_WRITE },
            { "micheal",    "calc", "/project-c/",     AccessLevel.READ_WRITE },
            { "sally",      "calc", "/project-c/",     AccessLevel.READ_WRITE },
            { "joe",        "calc", "/project-c/",     AccessLevel.READ_WRITE },
            { "decon",      "calc", "/project-c/",     AccessLevel.READ_WRITE },

            // anonymous
            { null,         "calc", "/project-c/",     AccessLevel.READ },

            // ~$anonmyous
            { "harry",      "calc", "/project-d/",     AccessLevel.READ_WRITE },
            { "brian",      "calc", "/project-d/",     AccessLevel.READ_WRITE },
            { "micheal",    "calc", "/project-d/",     AccessLevel.READ_WRITE },
            { "sally",      "calc", "/project-d/",     AccessLevel.READ_WRITE },
            { "joe",        "calc", "/project-d/",     AccessLevel.READ_WRITE },
            { "decon",      "calc", "/project-d/",     AccessLevel.READ_WRITE },

            // anonymous
            { null,         "calc", "/project-d/",     AccessLevel.NOTHING },

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
