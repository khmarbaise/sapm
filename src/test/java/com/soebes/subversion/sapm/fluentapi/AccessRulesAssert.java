package com.soebes.subversion.sapm.fluentapi;

import java.util.List;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

import com.soebes.subversion.sapm.AccessRule;
import com.soebes.subversion.sapm.AccessRules;

public class AccessRulesAssert extends GenericAssert<AccessRulesAssert, AccessRules> {

    protected AccessRulesAssert(AccessRules actual) {
        super(AccessRulesAssert.class, actual);
    }

    public static AccessRulesAssert assertThat(AccessRules actual) {
        return new AccessRulesAssert(actual);
    }

    public AccessRuleAssert hasRuleForRepository(String repositoryPath) {
        isNotNull();

        String errorMessage = String.format(
                "Expected repository to be <%s> but it does not exist <%s>",
                repositoryPath,
                actual.getAccessRules()
        );

        List<AccessRule> accessRules = actual.getAccessRules();

        AccessRule theAccessRuleToSearchFor = new AccessRule(repositoryPath);

        Assertions.assertThat(accessRules.contains(theAccessRuleToSearchFor)).overridingErrorMessage(errorMessage).isTrue();

        int indexOf = accessRules.indexOf(theAccessRuleToSearchFor);

        return AccessRuleAssert.assertThat(actual.getAccessRules().get(indexOf));
    }

}
