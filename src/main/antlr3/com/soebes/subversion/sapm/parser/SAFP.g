//
// Subversion Authentication Parse Module (SAPM)
//
// Copyright (c) 2010 by SoftwareEntwicklung Beratung Schulung (SoEBeS)
// Copyright (c) 2010 by Karl Heinz Marbaise
//
//
grammar SAFP;
options {
//	language = Java;
    output = AST;
}
@parser::header {
    package com.soebes.subversion.sapm.parser;

    import com.soebes.subversion.sapm.User;
    import com.soebes.subversion.sapm.Group;
    import com.soebes.subversion.sapm.AccessRule;
    import com.soebes.subversion.sapm.AccessRules;
    import com.soebes.subversion.sapm.Access;
    import com.soebes.subversion.sapm.AccessLevel;
    import com.soebes.subversion.sapm.IReference;

}
@lexer::header{
    package com.soebes.subversion.sapm.parser;
}
@members {
    private AccessRules accessRules = new AccessRules();
    public AccessRules getAccessRules() { return this.accessRules; }
}

/*
 * ----------------------------------------------------------------------------
 * Parser Rules
 * ----------------------------------------------------------------------------
 */
prog
    :	(statement)*;

statement
    :	groups
    |	repos { accessRules.add($repos.accessrule); }
    |	aliases
    ;

groups
    :	sectiongroup NL (group EQUAL groupuserdefinition
        {
            System.out.println("Group:" + $group.text + " def:" + $groupuserdefinition.text);
        }
        NL)*
    ;

repos returns [AccessRule accessrule; ] @init { System.out.println("Repository"); }
    :	sectionrule=sectionrepository NL
        perm=permissionrule {
            System.out.println("permission: " + $perm.text);
            $sectionrule.accessRule.add($perm.access);
        } NL?
        (
            perm1=permissionrule {
                System.out.println("permission: " + $perm1.text);
                $sectionrule.accessRule.add($perm1.access);
            }
            NL?
        )* { $accessrule = $sectionrule.accessRule; }
    ;

aliases @init { System.out.println("Init:Aliases"); }
    :	sectionaliases NL
        (
            alias EQUAL useraliasdefinition NL
            {
                System.out.println("ALIAS=" + $alias.text);
                System.out.println("DEF:" + $useraliasdefinition.text);
            }
        )*
    ;

group
    :	ID
    ;

alias
    :	ID
    ;

sectiongroup
    :	'[' GROUPS ']'
    ;

sectionaliases
    :	'[' ALIASES ']'
    ;

sectionrepository returns [ AccessRule accessRule; ]
    :	'[' repository repositorypath ']'
        {
            if ($repository.text == null) {
              $accessRule = new AccessRule($repositorypath.text);
              System.out.println("Repository->:" + $repositorypath.text);
            } else {
              $accessRule = new AccessRule($repository.repositoryId, $repositorypath.text);
              System.out.println("Repository:" + $repository.repositoryId +" " + $repositorypath.text);
            }
        }
    ;

repository returns [ String repositoryId; ]
    :	(ID ':')? { $repositoryId = $ID.text; }
    ;

repositorypath
    :	PATH
    ;

permissionrule returns [ Access access; ]
    :	userpermission { $access = $userpermission.access; }
    |	grouppermission{ $access = $grouppermission.access; }
    ;

userpermission returns [ Access access; ]
    :	user EQUAL permission
        {
            System.out.println("User:" + $user.text + " perm:" + $permission.perm);
            User userInstance = new User($user.text);
            $access = new Access(userInstance, $permission.perm);
        }
    ;

user
    : (ID|'*')
    ;

grouppermission returns [ Access access; ]
    :	groupreference EQUAL permission
        {
            System.out.println("Group:" + $groupreference.text + " perm:" + $permission.perm);
            Group groupInstance = new Group($groupreference.text);
            $access = new Access(groupInstance, $permission.perm);
        }
    ;

permission returns [ AccessLevel perm; ] @init { $perm = AccessLevel.NOTHING; }
    :	permission_read { $perm = AccessLevel.READ; }
    |	permission_write { $perm = AccessLevel.WRITE; }
    |	permission_read_write { $perm = AccessLevel.READ_WRITE; }
    |	permission_nothing
    ;

permission_read
    :	'r'
    |	'R'
    ;

permission_write
    :	'w'
    |	'W'
    ;

permission_read_write
    :	'rw'
    |	'RW'
    ;

permission_nothing
    :	NL
    ;

useraliasdefinition
    :	useralias (',' useralias)*
    ;

useralias
    :	ID EQUAL (ID)+
    ;

groupuserdefinition returns [ArrayList<IReference> gud; ] @init { $gud = new ArrayList<IReference>(); }
    :	groupuserreference ( ',' groupuserreference )*
    ;

groupuserreference
    :	aliasreference
    |	groupreference
    |	userreference
    ;

aliasreference
    :	'&' ID
    ;

groupreference
    :	'@' ID
    ;

userreference
    :	ID
    ;

/*
 * ----------------------------------------------------------------------------
 * Lexer Rules
 * ----------------------------------------------------------------------------
 */

EQUAL	:	'=';

GROUPS	:	'groups';

ALIASES	:	'aliases';

WS		: ( '\t' | ' ' )+ { $channel = HIDDEN; };

CHARACTERS:	'_'|'a'..'z'|'A'..'Z'|'.'|'-'
        ;

INTEGER_DIGITS
        :	'0'..'9'+
        ;

ID		:	CHARACTERS (CHARACTERS | INTEGER_DIGITS)*
        ;

PATH	:	'/' (CHARACTERS | INTEGER_DIGITS | '/')*
        ;

NL		:	('\r' | '\n')+
        ;
