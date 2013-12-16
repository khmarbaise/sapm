package com.soebes.subversion.sapm.fluentapi;

import java.util.List;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

import com.soebes.subversion.sapm.AccessRule;
import com.soebes.subversion.sapm.AccessRules;

public class AccessRulesAssert extends GenericAssert<AccessRulesAssert, AccessRules>{

    protected AccessRulesAssert(AccessRules actual) {
        super(AccessRulesAssert.class, actual);
    }

    public static AccessRulesAssert assertThat(AccessRules actual) {
        return new AccessRulesAssert(actual);
    }
    
    public AccessRuleAssert hasRuleForRepository(String repository) {
        isNotNull();

        String errorMessage = String.format(
                "Expected repository to be <%s> but was <%s>",
                repository,
                actual.getAccessRules()
        );

        List<AccessRule> accessRules = actual.getAccessRules();
        boolean contains = accessRules.contains(repository);
        
        Assertions.assertThat(actual.getAccessRules().contains(repository)).overridingErrorMessage(errorMessage).isEqualTo(contains);
        
        int indexOf = actual.getAccessRules().indexOf(repository);
        
        return AccessRuleAssert.assertThat(actual.getAccessRules().get(indexOf));
    }
    
}
