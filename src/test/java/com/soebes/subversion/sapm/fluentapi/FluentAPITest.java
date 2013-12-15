package com.soebes.subversion.sapm.fluentapi;

import static org.fest.assertions.api.Assertions.assertThat;

import org.testng.annotations.Test;

import com.soebes.subversion.sapm.AccessLevel;
import com.soebes.subversion.sapm.AccessRule;
import com.soebes.subversion.sapm.AccessRules;
import com.soebes.subversion.sapm.User;
import com.soebes.subversion.sapm.UserFactory;

public class FluentAPITest {

    @Test
    public void baseTest() {
        AccessRules accessRules = new AccessRules.Builder().build();
        assertThat(accessRules.getAccessRules()).isNotNull().hasSize(0);
    }

    @Test
    public void gegenTest() {
        AccessRules rules = new AccessRules();
        User userAsterik = UserFactory.createInstance("*");
        User userHarry = UserFactory.createInstance("harry");
        User userBrian = UserFactory.createInstance("brian");

        AccessRule rule1 = new AccessRule("/");
        rule1.add(userAsterik, AccessLevel.READ);
        rule1.add(userHarry, AccessLevel.READ);
        rule1.add(userBrian, AccessLevel.READ);

        rules.add(rule1);

        assertThat(rules.getAccessRules()).hasSize(1);
    }

    @Test
    public void voidFirstTest() {
        AccessRules accessRules = new AccessRules.Builder()
            .forRepository("/")
            .forUser("*").and("harry").and("brian")
            .with(AccessLevel.READ)
            .build();

        assertThat(accessRules.getAccessRules()).hasSize(1);
    }

    @Test
    public void thirdfirstTest() {
        AccessRules accessRules = new AccessRules.Builder()
            .forRepository("/")
            .forUser("*").and("harry").and("brian")
            .with(AccessLevel.READ)
            .forRepository("repository")
            .forUser("harry").and("brian")
            .with(AccessLevel.READ_WRITE)
            .build();
        assertThat(accessRules.getAccessRules()).hasSize(2);
    }

    public void secondTest() {
        /*
         * AccessRules accessRule = new AccessRules.Builder()
         * .group("c-developer").withMember("harry").and("brian")
         * .group("d-developer").withMember("michael").and("sally")
         * .group("e-developer").withMember("jonas")
         * .group("all-developer").withMember
         * ("c-developer").and("d-developer").and("e-developer")
         * .ofRepository("/") .with(AccessLevel.READ).forUser("*")
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
