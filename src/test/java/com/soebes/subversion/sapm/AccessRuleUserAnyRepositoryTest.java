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

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * This test will create an AccessRule as follows:
 *
 * <pre>
 * [/test/trunk]
 * harry = rw
 * brian = r
 * michael = rw
 * </pre>
 *
 * The tests will check if the AccessLevel will be extracted correctly and
 * furthermore if the access to different directories inside this repository
 * will work well.
 *
 * @author Karl Heinz Marbaise
 *
 */
public class AccessRuleUserAnyRepositoryTest {

    private AccessRule accessRule;

    @BeforeMethod
    public void beforeMethod() {
        User userHarry = UserFactory.createInstance("harry");
        User userBrian = UserFactory.createInstance("brian");
        User userMicheal = UserFactory.createInstance("michael");

        accessRule = new AccessRule("/test/trunk");

        accessRule.add(userHarry, AccessLevel.READ_WRITE);
        accessRule.add(userBrian, AccessLevel.READ);
        accessRule.add(userMicheal, AccessLevel.READ_WRITE);

    }

    @Test
    public void accessTest() {
        AccessLevel al_harry = accessRule.getAccessForPrincipal("harry");
        Assert.assertEquals(AccessLevel.READ_WRITE, al_harry);

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
            { "harry", "repository", "/",                           AccessLevel.NOTHING },
            { "harry", "repository", "/test/trunk/",                AccessLevel.READ_WRITE },
            { "harry", "repository", "/test/trunk/src/",            AccessLevel.READ_WRITE },
            { "harry", "repository", "/test/trunk/src/xyz.java",    AccessLevel.READ_WRITE },
            { "harry", "repository", "/test/trunk/src/CHANGELOG",   AccessLevel.READ_WRITE },
            { "brian", "repository", "/test/trunk/src/xyz.java",    AccessLevel.READ },
            { "brian", "repository", "/test/trunk/src/CHANGELOG",   AccessLevel.READ },
            { "sally", "repository", "/test/trunk/src/xyz.java",    AccessLevel.NOTHING },
            { "brian", "repository", "/test/trunk/",                AccessLevel.READ },
            { "sally", "repository", "/test/trunk/",                AccessLevel.NOTHING },
            { "harry", "different", "/test/trunk/",                 AccessLevel.READ_WRITE },
        };
    }

    @Test(dataProvider = "createAccessSet")
    public void accessRuleCheck(String user, String repository,
            String accessPath, AccessLevel expectedLevel) {
        // Check the permission of the current user in the repository within the
        // given accessPath
        AccessLevel al_user = accessRule
        .getAccess(user, repository, accessPath);
        Assert.assertEquals(expectedLevel, al_user);
    }

}
