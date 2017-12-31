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

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * This test will create AccessRules as follows:
 *
 * <pre>
 * [groups]
 * calc-developers = harry, sally, joe
 * calc-owners = hewlett, packard
 * calc = &#64;calc-developers, &#64;calc-owners
 *
 * # Any calc participant has read-write access...
 * [calc:/projects/calc]
 * &#64;calc = rw
 *
 * # ...but only allow the owners to make and modify release tags.
 * [calc:/projects/calc/tags]
 * &#64;calc-owners = rw
 * </pre>
 *
 * @author Karl Heinz Marbaise
 *
 */
public class AccessRulesGroupContainsTest {

    private AccessRules accessRules;

    /**
     * This method will define the following rule:
     *
     * <pre>
     * [groups]
     * calc-developers = harry, sally, joe
     * calc-owners = hewlett, packard
     * calc = &#64;calc-developers, &#64;calc-owners
     *
     * # Any calc participant has read-write access...
     * [calc:/projects/calc]
     * &#64;calc = rw
     *
     * # ...but only allow the owners to make and modify release tags.
     * [calc:/projects/calc/tags]
     * &#64;calc-developers = r
     * </pre>
     */
    @BeforeMethod
    public void beforeMethod() {
        accessRules = new AccessRules();

        User userHarry = UserFactory.createInstance("harry");
        User userSally = UserFactory.createInstance("sally");
        User userJoe = UserFactory.createInstance("joe");
        User userHewlett = UserFactory.createInstance("hewlett");
        User userPackard = UserFactory.createInstance("packard");


        Group calcDevelopers = new Group("calc-developers");
        // @calc-developers = harry, sally, joe
        calcDevelopers.add(userHarry);
        calcDevelopers.add(userSally);
        calcDevelopers.add(userJoe);

        Group calcOwners = new Group("calc-owners");
        // @calc-owners = hewlett, packard
        calcOwners.add(userHewlett);
        calcOwners.add(userPackard);

        // calc = @calc-developers, @calc-owners
        Group calc = new Group("calc");
        calc.add(calcDevelopers);
        calc.add(calcOwners);

        // [calc:/projects/calc]
        // @calc = rw
        AccessRule ar_1 = new AccessRule("calc", "/projects/calc");
        ar_1.add(calc, AccessLevel.READ_WRITE);

        // [calc:/projects/calc/tags]
        // @calc-developers = r
        AccessRule ar_2 = new AccessRule("calc", "/projects/calc/tags");
        ar_2.add(calcDevelopers, AccessLevel.READ);

        accessRules.add(ar_1);
        accessRules.add(ar_2);
    }

    @DataProvider(name = "createAccessSet")
    public Object[][] createAccessSet() {
        return new Object[][] {
            { "harry",      "calc", "/",                            AccessLevel.NOTHING },
            { "harry",      "calc", "/projects/",                   AccessLevel.NOTHING },

            { "sally",      "calc", "/",                            AccessLevel.NOTHING },
            { "sally",      "calc", "/projects/",                   AccessLevel.NOTHING },

            { "joe",        "calc", "/",                            AccessLevel.NOTHING },
            { "joes",       "calc", "/projects/",                   AccessLevel.NOTHING },

            { "hewlett",    "calc", "/",                            AccessLevel.NOTHING },
            { "hewlett",    "calc", "/projects/",                   AccessLevel.NOTHING },

            { "packard",    "calc", "/",                            AccessLevel.NOTHING },
            { "packard",    "calc", "/projects/",                   AccessLevel.NOTHING },


            { "harry",      "calc", "/projects/calc/",              AccessLevel.READ_WRITE },
            { "harry",      "calc", "/projects/calc/trunk/",        AccessLevel.READ_WRITE },
            { "harry",      "calc", "/projects/calc/branches/",     AccessLevel.READ_WRITE },

            { "sally",      "calc", "/projects/calc/",              AccessLevel.READ_WRITE },
            { "sally",      "calc", "/projects/calc/trunk/",        AccessLevel.READ_WRITE },
            { "sally",      "calc", "/projects/calc/branches/",     AccessLevel.READ_WRITE },

            { "joe",        "calc", "/projects/calc/",              AccessLevel.READ_WRITE },
            { "joe",        "calc", "/projects/calc/trunk/",        AccessLevel.READ_WRITE },
            { "joe",        "calc", "/projects/calc/branches/",     AccessLevel.READ_WRITE },

            { "hewlett",    "calc", "/projects/calc/",              AccessLevel.READ_WRITE },
            { "hewlett",    "calc", "/projects/calc/trunk/",        AccessLevel.READ_WRITE },
            { "hewlett",    "calc", "/projects/calc/branches/",     AccessLevel.READ_WRITE },

            { "packard",    "calc", "/projects/calc/",              AccessLevel.READ_WRITE },
            { "packard",    "calc", "/projects/calc/trunk/",        AccessLevel.READ_WRITE },
            { "packard",    "calc", "/projects/calc/branches/",     AccessLevel.READ_WRITE },


            { "harry",      "calc", "/projects/calc/tags/",         AccessLevel.READ },
            { "sally",      "calc", "/projects/calc/tags/",         AccessLevel.READ },
            { "joe",        "calc", "/projects/calc/tags/",         AccessLevel.READ },
            { "hewlett",    "calc", "/projects/calc/tags/",         AccessLevel.READ_WRITE },
            { "packard",    "calc", "/projects/calc/tags/",         AccessLevel.READ_WRITE },

            { "harry",      "calc", "/projects/calc/tags",          AccessLevel.READ_WRITE },
            { "sally",      "calc", "/projects/calc/tags",          AccessLevel.READ_WRITE },
            { "joe",        "calc", "/projects/calc/tags",          AccessLevel.READ_WRITE },

        };
    }

    @Test(dataProvider = "createAccessSet")
    public void accessRuleCheck(String user, String repository, String accessPath, AccessLevel expectedLevel) {
        AccessLevel al_user = accessRules.getAccess(user, repository, accessPath);
        Assert.assertEquals(expectedLevel, al_user);
    }

}
