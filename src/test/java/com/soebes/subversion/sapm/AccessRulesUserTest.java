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
 * This test will create AccessRules as follows:
 *
 * <pre>
 * [/]
 * * = r
 *
 * [repository:/test/trunk]
 * harry = rw
 * michael = rw
 * </pre>
 *
 * @author Karl Heinz Marbaise
 *
 */
public class AccessRulesUserTest {

    private AccessRules accessRules;

    /**
     * This method will define the following rule:
     *
     */
    @BeforeMethod
    public void beforeMethod() {
        accessRules = new AccessRules();

        UserAsterik userAsterik = new UserAsterik();
        AccessRule accessRuleRoot = new AccessRule("/");
        accessRuleRoot.add(userAsterik, AccessLevel.READ);
        accessRules.add(accessRuleRoot);

        User userHarry = new User("harry");
        User userMicheal = new User("michael");

        AccessRule accessRule = new AccessRule("repository", "/test/trunk");
        accessRule.add(userHarry, AccessLevel.READ_WRITE);
        accessRule.add(userMicheal, AccessLevel.READ_WRITE);
        accessRules.add(accessRule);

    }

    @DataProvider(name = "createAccessSet")
    public Object[][] createAccessSet() {
        return new Object[][] {
            { "harry",      "repository",    "/",                            AccessLevel.READ },
            { "harry",      "repository",    "/test/trunk/",                 AccessLevel.READ_WRITE },
            { "harry",      "repository",    "/test/trunk/src/",             AccessLevel.READ_WRITE },
            { "harry",      "repository",    "/test/trunk/src/xyz.java",     AccessLevel.READ_WRITE },
            { "harry",      "repository",    "/test/trunk/src/CHANGELOG",    AccessLevel.READ_WRITE },

            { "michael",    "repository",    "/test/trunk/",                 AccessLevel.READ_WRITE },
            { "michael",    "repository",    "/test/trunk/src/",             AccessLevel.READ_WRITE },

            { "brian",      "repository",    "/test/trunk/src/xyz.java",     AccessLevel.READ },
            { "brian",      "repository",    "/test/trunk/src/CHANGELOG",    AccessLevel.READ },
            { "sally",      "repository",    "/test/trunk/src/xyz.java",     AccessLevel.READ },
            { "brian",      "repository",    "/test/trunk/",                 AccessLevel.READ },
            { "sally",      "repository",    "/test/trunk/",                 AccessLevel.READ },
            { "harry",      "different",     "/test/trunk/",                 AccessLevel.READ },
            { "michale",    "different",     "/test/",                       AccessLevel.READ },
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
