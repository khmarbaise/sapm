/**
 * The Subversion Authentication Parse Module (SAPM for short).
 *
 * Copyright (c) 2010, 2011 by SoftwareEntwicklung Beratung Schulung (SoEBeS)
 * Copyright (c) 2010, 2011 by Karl Heinz Marbaise
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 *
 * The License can viewed online under http://www.gnu.org/licenses/gpl.html
 * If you have any questions about the Software or about the license
 * just write an email to license@soebes.de
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
