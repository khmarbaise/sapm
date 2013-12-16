package com.soebes.subversion.sapm.fluentapi;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

import com.soebes.subversion.sapm.AccessLevel;
import com.soebes.subversion.sapm.AccessRule;

public class AccessRuleAssert extends GenericAssert<AccessRuleAssert, AccessRule>{

    protected AccessRuleAssert(AccessRule actual) {
        super(AccessRuleAssert.class, actual);
    }

    public static AccessRuleAssert assertThat(AccessRule actual) {
        return new AccessRuleAssert(actual);
    }
    
    public AccessRuleAssert with(AccessLevel level) {
        isNotNull();
        
        return this;
    }

    public AccessRuleAssert and(String userName) {
        isNotNull();
        Assertions.assertThat(actual.getAccessList()).contains(userName)
        .overridingErrorMessage("This is the message from AccessRuleAssert()");
        return this;
    }

    public AccessRuleAssert forUser(String userName) {
        isNotNull();
        
        Assertions.assertThat(actual.getAccessList()).contains(userName).overridingErrorMessage("Message AssessRuleAssert.forUser()");
        
//        Assertions.assertThat(actual.getAccessList())
//        .contains(userName)
//        .overridingErrorMessage("TEST");

        return this;
    }
    
}
