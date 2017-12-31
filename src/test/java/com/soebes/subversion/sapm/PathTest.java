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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PathTest extends TestBase {

    @DataProvider(name = "createRepositoryPaths")
    public Object[][] createRepositoryPaths() {
        return new Object[][] {
            { "/test/trunk/", "/test/trunk/xyz.pas",        true },
            { "/test/trunk/", "/test/trunk/src/main/java/", true },
            { "/test/trunk/", "/test/trunk/",               true },
            { "/test/trunk/", "/test/",                     false },
        };
    }

    @Test(dataProvider = "createRepositoryPaths")
    public void folderTestWithX(String repository, String checkPath,
            boolean result) {
        Path f = new Path(repository);
        Assert.assertEquals(result, f.contains(checkPath));
    }

}
