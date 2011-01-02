Subversion Authentication Parser Module
=======================================

The idea is to read the [authentication file of Subversion](http://svnbook.red-bean.com/nightly/en/svn-book.html#svn.serverconfig.pathbasedauthz)
and convert it into a form which can be used inside an application.

This means to check a user against the configuration for example if a user is
allowed to read a particular path in a special repository or not.

Status
======
- Object model created and fit my needs.
- ANTLR Grammar works reading
- Combination of the above parts is not yet done.
  - The first configuration can be read and produces a correct AccessRules instance.


The following rule set can be handled with the classes:

    [/]
    * = r
    [repository:/test]
    harry = rw
    brian = rw

The above configuration contents can be created by using the following code snippet:
<code>
    AccessRules accessRules = new AccessRules();

    User user = UserFactory.createInstance("*");
    AccessRule accessRuleRoot = new AccessRule("/");
    accessRuleRoot.add(user, AccessLevel.READ);
    accessRules.add(accessRuleRoot);

    User userHarry = UserFactory.createInstance("harry");
    User userBrian = UserFactory.createInstance("brian");

    AccessRule accessRule = new AccessRule("repository", "/test/trunk");
    accessRule.add(userHarry, AccessLevel.READ_WRITE);
    accessRule.add(userMicheal, AccessLevel.READ_WRITE);
    accessRules.add(accessRule);
</code>

And now finally you can ask the AccessRules class what kind of permission a particular user has whereas
the user is the user name for example "harry" and the repository for which repository you would like to
check the permission and the accessPath defines which path inside the repository the user tries to access.

    AccessLevel al_user = accessRules.getAccess(user, repository, accessPath);
