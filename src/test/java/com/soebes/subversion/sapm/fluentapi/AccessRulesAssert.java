package com.soebes.subversion.sapm.fluentapi;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

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
        
        Assertions.assertThat(actual.getAccessRules()).contains(repository).overridingErrorMessage("this is the message");

        int indexOf = actual.getAccessRules().indexOf(repository);
        
        return AccessRuleAssert.assertThat(actual.getAccessRules().get(indexOf));
    }
    
}
