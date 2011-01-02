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

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Karl Heinz Marbaise
 *
 */
@Test()
public class FileNameTest {

    @DataProvider(name = "createTestList")
    public Object[][] createTestList() {
        return new Object[][] {
            { "/usr/local/test.zip",    "zip",      "test.zip",     "test",     "/usr/local/" },
            { "/usr/local/test.tar.gz", "tar.gz",   "test.tar.gz",  "test",     "/usr/local/" },
            { "C:/Programme/x-y-z.zip", "zip",      "x-y-z.zip",    "x-y-z",    "C:/Programme/" },
            { "/x.zip",                 "zip",      "x.zip",        "x",        "/" },
            { "/branches/",             "",         "",             "",         "/branches/" },
            { "/branches",              "",         "branches",     "branches", "/" },
            { "/",                      "",         "",             "",         "/" },
        };
    }

    @Test(dataProvider = "createTestList")
    public void check(String fileName, String ext, String baseName,
            String nameWithoutExtension, String path) {
        FileName fn = new FileName(fileName);
        assertEquals(fn.getExt(), ext);
        assertEquals(fn.getBaseName(), baseName);
        assertEquals(fn.getNameWithoutExtension(), nameWithoutExtension);
        assertEquals(fn.getPath(), path);
    }

    // This is not in the dataProvider list!!!
    public void testF61() {
        String fileName = "/branches";
        FileName fn = new FileName(fileName, true);
        assertEquals(fn.getExt(), "", "The extension is not as expected.");
        assertEquals(fn.getBaseName(), "", "The basename is not as expected.");
        assertEquals(fn.getNameWithoutExtension(), "",
        "The name without extension is not as expected.");
        assertEquals(fn.getPath(), "/branches/", "The path is not as expected.");
    }

    // This is not in the dataProvider list!!!
    public void testF80() {
        String fileName = "/tags/1.5.o-beta1";
        FileName fn = new FileName(fileName, true);
        assertEquals(fn.getExt(), "", "The extension is not as expected.");
        assertEquals(fn.getBaseName(), "", "The basename is not as expected.");
        assertEquals(fn.getNameWithoutExtension(), "",
        "The name without extension is not as expected.");
        assertEquals(fn.getPath(), "/tags/1.5.o-beta1/",
        "The path is not as expected.");
    }

    // This is not in the dataProvider list!!!
    public void testF90() {
        String fileName = "/branches/B_0.4.0/.project";
        FileName fn = new FileName(fileName, false);
        assertEquals(fn.getExt(), "project",
        "The extension is not as expected.");
        assertEquals(fn.getBaseName(), ".project",
        "The basename is not as expected.");
        assertEquals(fn.getNameWithoutExtension(), "",
        "The name without extension is not as expected.");
        assertEquals(fn.getPath(), "/branches/B_0.4.0/",
        "The path is not as expected.");
    }

    // This is not in the dataProvider list!!!
    /**
     * This test is based on issue #215 as well as the test in
     * SearchRepositoryTest#testQueryForREADMEFileIssue215
     */
    public void testF100() {
        String fileName = "/branches/B_0.4.0/README";
        FileName fn = new FileName(fileName, false);
        assertEquals(fn.getExt(), "", "The extension is not as expected.");
        assertEquals(fn.getBaseName(), "README",
        "The basename is not as expected.");
        assertEquals(fn.getNameWithoutExtension(), "README",
        "The name without extension is not as expected.");
        assertEquals(fn.getPath(), "/branches/B_0.4.0/",
        "The path is not as expected.");
    }

}
