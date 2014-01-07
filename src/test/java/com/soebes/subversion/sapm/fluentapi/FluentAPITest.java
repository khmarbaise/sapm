package com.soebes.subversion.sapm.fluentapi;

import com.soebes.subversion.sapm.AccessLevel;
import com.soebes.subversion.sapm.AccessRule;
import com.soebes.subversion.sapm.AccessRules;
import com.soebes.subversion.sapm.UserFactory;
import org.testng.annotations.Test;
import static com.soebes.subversion.sapm.fluentapi.AccessRulesAssert.assertThat;

public class FluentAPITest {

    @Test
    public void theBuilderShouldReturnAnInstanceOfAccessRules() {
        AccessRules accessRules = new AccessRules.Builder().build();
        assertThat(accessRules).isNotNull().hasSize(0);
    }

    /**
     *<pre>{@code  [/]
     ** = r
     *harry = r
     *brian = r
     *}</pre>
     *
     *
     *
     */
    @Test
    public void shouldUseTheSelfImplementedHasSize() {
        AccessRules rules = new AccessRules();

        AccessRule rule1 = new AccessRule("/");
        rule1.add(UserFactory.createInstance("*"), AccessLevel.READ);
        rule1.add(UserFactory.createInstance("harry"), AccessLevel.READ);
        rule1.add(UserFactory.createInstance("brian"), AccessLevel.READ);

        rules.add(rule1);

        assertThat(rules).hasSize(1);
    }

    @Test
    public void voidFirstTest() {
        //@formatter:off
        AccessRules accessRules = new AccessRules.Builder()
            .forRepository("/")
            .forUser("*").and("harry").and("brian")
            .with(AccessLevel.READ)
            .build();
        //@formatter:on

        assertThat(accessRules)
            .hasRuleForRepository("/")
            .withUser("*").and("harry").and("brian")
            .with(AccessLevel.READ);
//            .and("harry")
//            .and("brian").with(AccessLevel.READ);

//        assertThat(accessRules.getAccessRules()).hasSize(1);
    }

    @Test
    public void thirdFirstTest() {
        //@formatter:off
        AccessRules accessRules = new AccessRules.Builder()
            .forRepository("/")
            .forUser("*").and("harry").and("brian")
            .with(AccessLevel.READ)
            .forRepository("repository")
            .forUser("harry").and("brian")
            .with(AccessLevel.READ_WRITE)
            .build();
        //@formatter:on

//        assertThat(accessRules.getAccessRules()).hasSize(2);

        AccessRule accessRule_1 = accessRules.getAccessRules().get(0);

//        assertThat(accessRule_1.getAccessList()).hasSize(3);
//        assertThat(accessRule_1.getAccessList().get(0).getPrincipal().getName()).isEqualTo("*");
//        assertThat(accessRule_1.getAccessList().get(1).getPrincipal().getName()).isEqualTo("harry");
//        assertThat(accessRule_1.getAccessList().get(2).getPrincipal().getName()).isEqualTo("brian");
//        assertThat(accessRule_1.getAccessList().get(0).getLevel()).isEqualTo(AccessLevel.READ);

        AccessRule accessRule_2 = accessRules.getAccessRules().get(1);

//        assertThat(accessRule_2.getAccessList()).hasSize(2);
//        assertThat(accessRule_2.getAccessList().get(0).getPrincipal().getName()).isEqualTo("harry");
//        assertThat(accessRule_2.getAccessList().get(1).getPrincipal().getName()).isEqualTo("brian");
//        assertThat(accessRule_2.getAccessList().get(0).getLevel()).isEqualTo(AccessLevel.READ_WRITE);
    }

    public void secondTest() {
        /*
         * AccessRules accessRule = new AccessRules.Builder()
         * .group("c-developer").withMember("harry").and("brian")
         * .group("d-developer").withMember("michael").and("sally")
         * .group("e-developer").withMember("jonas")
         * .group("all-developer").withMember
         * ("c-developer").and("d-developer").and("e-developer")
         * .ofRepository("/") .with(AccessLevel.READ).withUser("*")
         * .ofRepository("repository", "/project-c/trunk")
         * .with(AccessLevel.READ_WRITE).forGroup("c-developer")
         * .ofRepository("repository", "/project-d/trunk")
         * .with(AccessLevel.READ_WRITE).forGroup("d-developer")
         * .ofRepository("repository", "/project-e/trunk")
         * .with(AccessLevel.READ_WRITE).forGroup("e-developer")
         * .ofRepository("global", "/project/trunk")
         * .with(AccessLevel.READ_WRITE).forGroup("all-developer") .build();
         */
    }
}
