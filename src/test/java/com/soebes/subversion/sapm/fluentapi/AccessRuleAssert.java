package com.soebes.subversion.sapm.fluentapi;

import com.google.common.base.Joiner;
import com.soebes.subversion.sapm.*;
import org.fest.assertions.Assert;
import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

import java.util.ArrayList;
import java.util.List;

public class AccessRuleAssert extends GenericAssert<AccessRuleAssert, AccessRule>{

    private List<User> userList;

    protected AccessRuleAssert(AccessRule actual) {
        super(AccessRuleAssert.class, actual);
        userList = new ArrayList<User>();
    }

    public static AccessRuleAssert assertThat(AccessRule actual) {
        return new AccessRuleAssert(actual);
    }
    
    public AccessRuleAssert with(AccessLevel level) {
        isNotNull();

        Assertions.assertThat(userList).isNotEmpty();

            //We have to check the user list...against the
            //user in the AccessLevel ist.

        return this;
    }

    public AccessRuleAssert and(String userName) {
        isNotNull();
        Assertions.assertThat(actual.getAccessList()).contains(userName)
        .overridingErrorMessage("This is the message from AccessRuleAssert()");
        userList.add(UserFactory.createInstance(userName));
        return this;
    }

    public AccessRuleAssert withUser(String userName) {
        isNotNull();

        StringBuilder sb = new StringBuilder();
        for (Access item : actual.getAccessList()) {
            sb.append(item.getPrincipal().getName());
            sb.append(",");
        }

        String errorMessage = String.format(
                "Expected userName <%s> but it does not exist in list of users <%s>",
                userName,
                sb.toString()
        );

        boolean result = actual.getAccessList().contains(UserFactory.createInstance(userName));

        Assertions.assertThat(actual.getAccessList()).overridingErrorMessage(errorMessage).contains(UserFactory.createInstance(userName));

        userList.add(UserFactory.createInstance(userName));
//        Assertions.assertThat(actual.getAccessList())
//        .contains(userName)
//        .overridingErrorMessage("TEST");

        return this;
    }
    
}
