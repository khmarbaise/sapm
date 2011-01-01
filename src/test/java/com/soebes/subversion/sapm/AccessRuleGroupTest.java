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
 * developer = harry, brian
 * admin = micheal
 * [repository:/test/trunk]
 * @developer = r
 * @admin = rw
 * </pre>
 *
 * The tests will check if the AccessLevel will be extracted correctly and
 * furthermore if the access to different directories inside this repository
 * will work well.
 *
 * @author Karl Heinz Marbaise
 *
 */
public class AccessRuleGroupTest {

    private AccessRule accessRule;

    /**
     * This method will define the following rule:
     *
     * <pre>
     * [groups]
     * developer = harry, brian
     * admin = micheal
     * [repository:/test/trunk]
     * @developer = r
     * @admin = rw
     * </pre>
     */
    @BeforeMethod
    public void beforeMethod() {
        User userHarry = new User("harry");
        User userBrian = new User("brian");
        User userMicheal = new User("michael");

        Group developerGroup = new Group("developer");

        // @developer = harry, brian
        developerGroup.add(userHarry);
        developerGroup.add(userBrian);

        Group adminGroup = new Group("admin");

        // @admin = michael
        adminGroup.add(userMicheal);

        // [repository:/test/trunk]
        // @developer = r
        // @admin = rw
        accessRule = new AccessRule("repository", "/test/trunk");

        accessRule.add(developerGroup, AccessLevel.READ);
        accessRule.add(adminGroup, AccessLevel.READ_WRITE);

    }

    @Test
    public void accessTest() {
        AccessLevel al_harry = accessRule.getAccessForPrincipal("harry");
        Assert.assertEquals(AccessLevel.READ, al_harry);

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
                { "harry", "repository", "/", AccessLevel.NOTHING },
                { "harry", "repository", "/test/trunk/", AccessLevel.READ },
                { "harry", "repository", "/test/trunk/src/", AccessLevel.READ },
                { "harry", "repository", "/test/trunk/src/xyz.java",
                    AccessLevel.READ },
                    { "harry", "repository", "/test/trunk/src/CHANGELOG",
                        AccessLevel.READ },

                        { "brian", "repository", "/test/trunk/src/xyz.java",
                            AccessLevel.READ },
                            { "brian", "repository", "/test/trunk/src/CHANGELOG",
                                AccessLevel.READ },

                                { "sally", "repository", "/test/trunk/src/xyz.java",
                                    AccessLevel.NOTHING },
                                    { "sally", "repository", "/test/trunk/", AccessLevel.NOTHING },
                                    { "harry", "different", "/test/trunk/", AccessLevel.NOTHING },
                                    { "michael", "different", "/test/trunk/", AccessLevel.NOTHING },
                                    { "brian", "different", "/test/trunk/", AccessLevel.NOTHING },

                                    { "michael", "repository", "/test/trunk/",
                                        AccessLevel.READ_WRITE },
                                        { "michael", "repository", "/test/trunk/",
                                            AccessLevel.READ_WRITE },
                                            { "michael", "repository", "/test/trunk/src/",
                                                AccessLevel.READ_WRITE },
                                                { "michael", "repository", "/test/trunk/src/xyz.java",
                                                    AccessLevel.READ_WRITE },
                                                    { "michael", "repository", "/test/trunk/src/CHANGELOG",
                                                        AccessLevel.READ_WRITE },

                                                        { "michael", "repository", "/test/trunk/src/xyz.java",
                                                            AccessLevel.READ_WRITE },
                                                            { "michael", "repository", "/test/trunk/src/CHANGELOG",
                                                                AccessLevel.READ_WRITE }, };
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
