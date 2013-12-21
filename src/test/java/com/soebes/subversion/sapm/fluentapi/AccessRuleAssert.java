package com.soebes.subversion.sapm.fluentapi;

import com.soebes.subversion.sapm.User;
import com.soebes.subversion.sapm.UserFactory;
import org.fest.assertions.Assert;
import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

import com.soebes.subversion.sapm.AccessLevel;
import com.soebes.subversion.sapm.AccessRule;

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

        String errorMessage = String.format(
                "Expected userName <%s> but it does not exist in list of users <%s>",
                userName,
                actual.getAccessList()
        );

        boolean result = actual.getAccessList().contains(UserFactory.createInstance(userName));

        Assertions.assertThat(actual.getAccessList()).contains(UserFactory.createInstance(userName)).overridingErrorMessage(errorMessage);

        userList.add(UserFactory.createInstance(userName));
//        Assertions.assertThat(actual.getAccessList())
//        .contains(userName)
//        .overridingErrorMessage("TEST");

        return this;
    }
    
}
