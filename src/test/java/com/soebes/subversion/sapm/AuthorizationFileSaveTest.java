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

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Karl Heinz Marbaise
 */
public class AuthorizationFileSaveTest
    extends TestBase
{

    private AccessRules rules;

    @BeforeMethod
    public void beforeMethod()
    {
        User userHarry = UserFactory.createInstance( "harry" );
        User userBrian = UserFactory.createInstance( "brian" );

        Group developerGroup = new Group( "developer" );

        // @developer = harry, brian
        developerGroup.add( userHarry );
        developerGroup.add( userBrian );

        Group adminGroup = new Group( "admin" );

        // @admin = michael
        User userMicheal = UserFactory.createInstance( "michael" );
        adminGroup.add( userMicheal );

        // [repository:/test/trunk]
        // @developer = r
        // @admin = rw
        AccessRule accessRule = new AccessRule( "repository", "/test/trunk" );

        accessRule.add( developerGroup, AccessLevel.READ );
        accessRule.add( adminGroup, AccessLevel.READ_WRITE );

        AccessRules rules = new AccessRules();
        rules.add( accessRule );
        // System.out.println(accessRule);

    }

    @Test
    public void shouldSaveTheGroup()
    {
        List<AccessRule> accessRules = rules.getAccessRules();
        for ( AccessRule accessRule : accessRules )
        {
            List<Access> accessList = accessRule.getAccessList();
            for ( Access access : accessList )
            {
                IPrincipal principal = access.getPrincipal();
                principal.getName();
            }
        }
    }
}
