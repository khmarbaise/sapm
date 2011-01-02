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

import org.testng.annotations.Test;

public class GroupTest extends TestBase {

    @Test
    public void groupAddTest() {
        User userHarry = UserFactory.createInstance("harry");
        User userBrian = UserFactory.createInstance("brian");
        Group developerGroup = new Group("developer");

        // @developer = harry, brian
        developerGroup.add(userHarry);
        developerGroup.add(userBrian);
        Assert.assertEquals(2, developerGroup.getPrincipalList().size());
    }

    @Test
    public void groupContainsTest() {
        User userHarry = UserFactory.createInstance("harry");
        User userBrian = UserFactory.createInstance("brian");
        Group developerGroup = new Group("developer");

        // @developer = harry, brian
        developerGroup.add(userHarry);
        developerGroup.add(userBrian);
        Assert.assertTrue(developerGroup.contains(userHarry.getName()));
        Assert.assertTrue(developerGroup.contains(userHarry));
        Assert.assertTrue(developerGroup.contains(userBrian));

        Assert.assertFalse(developerGroup.contains("michael"));
    }

    @Test
    public void groupContainsGroupTest() {
        Group group1 = new Group("group1");
        group1.add(UserFactory.createInstance("harry"));
        group1.add(UserFactory.createInstance("michael"));

        Group group2 = new Group("group2");
        group2.add(UserFactory.createInstance("brian"));

        Group group3 = new Group("group3");
        group2.add(UserFactory.createInstance("sally"));

        Group groupAll = new Group("groupAdd");
        groupAll.add(group1);
        groupAll.add(group2);
        groupAll.add(group3);

        Assert.assertTrue(groupAll.contains("harry"));
        Assert.assertTrue(groupAll.contains("michael"));
        Assert.assertTrue(groupAll.contains("sally"));
        Assert.assertTrue(groupAll.contains("brian"));

        Assert.assertFalse(groupAll.contains("hugo"));
        Assert.assertFalse(groupAll.contains("fran"));
    }
}
