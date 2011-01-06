//
// The Subversion Authentication Parse Module (SAPM for short).
//
// Copyright (c) 2010, 2011 by SoftwareEntwicklung Beratung Schulung (SoEBeS)
// Copyright (c) 2010, 2011 by Karl Heinz Marbaise
//
// Licensed to the Apache Software Foundation (ASF) under one or more
// contributor license agreements.  See the NOTICE file distributed with
// this work for additional information regarding copyright ownership.
// The ASF licenses this file to You under the Apache License, Version 2.0
// (the "License"); you may not use this file except in compliance with
// the License.  You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

grammar SAFP;
options {
//	language = Java;
    output = AST;
}
@parser::header {
    package com.soebes.subversion.sapm.parser;

    import com.soebes.subversion.sapm.User;
    import com.soebes.subversion.sapm.Users;
    import com.soebes.subversion.sapm.UserFactory;
    import com.soebes.subversion.sapm.Group;
    import com.soebes.subversion.sapm.Groups;
    import com.soebes.subversion.sapm.AccessRule;
    import com.soebes.subversion.sapm.AccessRules;
    import com.soebes.subversion.sapm.Access;
    import com.soebes.subversion.sapm.AccessLevel;
    import com.soebes.subversion.sapm.IPrincipal;

}
@lexer::header{
    package com.soebes.subversion.sapm.parser;
}
@members {
    private AccessRules accessRules = new AccessRules();
    public AccessRules getAccessRules() { return this.accessRules; }
    private Groups groups = new Groups();
    public Groups getGroups() { return this.groups; }
    private Users users = new Users();
    public Users getUsers() { return this.users; }
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
    |	repos { getAccessRules().add($repos.accessrule); }
    |	aliases
    ;

groups
    :	sectiongroup NL (group EQUAL groupuserdefinition
        {
          Group group = new Group($group.text);
          for (IPrincipal item:$groupuserdefinition.gud) {
            group.add(item);
          }
          getGroups().add(group);
        }
        NL)*
    ;

repos returns [ AccessRule accessrule; ]
    :	sectionrule=sectionrepository NL
        perm=permissionrule {
            $sectionrule.accessRule.add($perm.access);
        } NL?
        (
            perm1=permissionrule {
                $sectionrule.accessRule.add($perm1.access);
            }
            NL?
        )* { $accessrule = $sectionrule.accessRule; }
    ;

aliases @init {
  //System.out.println("Init:Aliases");
  }
    :	sectionaliases NL
        (
            alias EQUAL useraliasdefinition NL
            {
                //System.out.println("ALIAS=" + $alias.text);
                //System.out.println("DEF:" + $useraliasdefinition.text);
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
            } else {
              $accessRule = new AccessRule($repository.repositoryId, $repositorypath.text);
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
    |	grouppermission { $access = $grouppermission.access; }
    | aliaspermission { $access = $aliaspermission.access; }
    ;

userpermission returns [ Access access; ]
    :	user EQUAL permission
        {
            User userInstance = UserFactory.createInstance($user.text);
            $access = new Access(userInstance, $permission.perm);
        }
    | '~' user EQUAL permission
        {
            User userInstance = UserFactory.createInstance($user.text);
            $access = new Access(userInstance, $permission.perm, true);
        }
    ;

grouppermission returns [ Access access; ]
    :	groupreference EQUAL permission
        {
            IPrincipal groupInstance = getGroups().getGroup($groupreference.refId);
            $access = new Access(groupInstance, $permission.perm);
        }
    | '~' groupreference EQUAL permission
        {
            IPrincipal groupInstance = getGroups().getGroup($groupreference.refId);
            $access = new Access(groupInstance, $permission.perm, true);
        }
    ;

aliaspermission returns [ Access access; ]
    : aliasreference EQUAL permission
        {
            System.out.println("Alias " + $aliasreference.refId + " permission rule");
//            IPrincipal groupInstance = getGroups().getGroup($groupreference.refId);
//            $access = new Access(groupInstance, $permission.perm);
        }
    | '~' aliasreference EQUAL permission
        {
            System.out.println("Negative Alias permission rule");
        }
    ;

user
    : (ID|'*'|'$authenticated'|'$anonymous')
    ;

permission returns [ AccessLevel perm; ] @init { $perm = AccessLevel.NOTHING; }
    :	permission_read { $perm = AccessLevel.READ; }
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

groupuserdefinition returns [ArrayList<IPrincipal> gud; ] @init { $gud = new ArrayList<IPrincipal>(); }
    :	groupref1=groupuserreference { $gud.add($groupref1.principal); }
        ( ',' groupreffollow=groupuserreference { $gud.add($groupreffollow.principal); } )*
    ;

groupuserreference returns [ IPrincipal principal; ]
    :	aliasreference
    |	groupreference { $principal = getGroups().getGroup($groupreference.refId); }
    |	userreference { $principal = new User($userreference.refId); }
    ;

aliasreference returns [ String refId; ]
    :	'&' ID { $refId = $ID.text; }
    ;

groupreference returns [ String refId; ]
    :	'@' ID { $refId = $ID.text; }
    ;

userreference returns [ String refId;]
    :	ID { $refId = $ID.text; }
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
