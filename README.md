Subversion Authentication Parser Module
=======================================

The idea is to read the [authentication file of Subversion](http://svnbook.red-bean.com/nightly/en/svn-book.html#svn.serverconfig.pathbasedauthz)
and convert it into a form which can be used inside an application.

This means to check a user against the configuration for example if a user is
allowed to read a particular path in a special repository or not.

License
-------
[Apache License, Version 2.0, January 2004](http://www.apache.org/licenses/)


Status
------
- Object model created and fit my needs.
- ANTLR Grammar works reading
- Supports ~user, ~group rule
- Started with a simple API based on AuthorizationFile class.

TODOs
-----
- Grammar / Object Model
  - Handling of aliases (&alias) is not implemented (yet).
  - Handling the tokens $anonymous and $authenticated is not implemented (yet).

- Enhanced / Improve Authorization class.
  - Check what to do?
- Examples
- Check to see if the last rule is the one which counts.

Usage
-----

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


The following rule set works as well (see the following unit test AccessRulesGroupGroupTest.java):

    [groups]
    c-developer = harry, brian
    d-developer = michael, sally
    e-developer = jonas
    all-developer = @c-developer, @d-developer, @e-developer
    [/]
    * = r
    [repository:/project-c/trunk]
    @c-developer = rw
    [repository:/project-d/trunk]
    @d-developer = rw
    [repository:/project-e/trunk]
    @e-developer = rw
    [global:/project/trunk]
    @all-developer = rw

How to load the authentication file?
------------------------------------

You can load the authentication file by using the following code snippet and check the permission
of a given user against the repository and path inside the repository.


    AuthorizationFile authorizationFile
    try {
        authorizationFile = new AuthorizationFile();
        authorizationFile.load(new File("/path/to/svnaccess-groups-in-groups.conf"));
    } catch (AuthorizationFileException e) {
        System.out.println("Something has gone wrong: " + e.getMessage());
    }

    AccessLevel al_user = authorizationFile.getAccessRules().getAccess(user, repository, accessPath);

