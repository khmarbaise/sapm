Subversion Authentication Parser Module
=======================================

The idea is to read the [authentication file of Subversion](http://svnbook.red-bean.com/en/1.7/svn-book.html#svn.serverconfig.pathbasedauthz)
and convert it into a form which can be used inside an application.

This means to check a user against the configuration for example if a user is
allowed to read a particular path in a special repository or not.

License
-------
[Apache License, Version 2.0, January 2004](http://www.apache.org/licenses/)

Homepage
--------

The Maven Site for Release sapm-0.3 [http://khmarbaise.github.com/sapm](http://khmarbaise.github.com/sapm)

Status
------
- [Module is available via maven central](http://repo1.maven.org/maven2/com/soebes/subversion/sapm/sapm/)
- Object model created and fit my needs.
- ANTLR Grammar works reading
  - Support of ~user, ~group and ~alias rule
  - Support of user, groups and aliases rule
  - Support of $anonymous and $authenticated
- Started with a simple API based on AuthorizationFile class.

TODOs
-----
- Enhanced / Improve Authorization class.
  - Check what to do?
- May be more Examples
- Check to see if the last rule is the one which counts (check the SVN Book?)

Usage
-----

The following rule set can be handled either via the following code example
or directly using a configuration file which can be loaded via AuthorizationFile class:

    [/]
    * = r
    [repository:/test]
    harry = rw
    brian = rw

The above configuration contents can be created by using the following code snippet:

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

Order of permission rules
-------------------------

If you have the following rule set what kind of permission would you expect
for jenny in repository "calc" and folder "/project/" ? READ/WRITE? No.
She will get only the READ permission cause the last rule defines
READ permision explicit for her. This means the order counts.

    [groups]
    groupa = jenny, joe, danny
    [calc:/project/]
    @groupa = rw
    jenny = r

If you do the previous case exactly reverse order like this:
    
    [groups]
    groupa = jenny, joe, danny
    [calc:/project/]
    jenny = r
    @groupa = rw

Than you will get READ/WRITE permission for jenny, cause the last
rule counts.


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

