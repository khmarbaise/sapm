package com.soebes.subversion.sapm.fluentapi;

import com.soebes.subversion.sapm.*;
import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;
import java.util.ArrayList;
import java.util.List;

public class AccessRuleAssert extends GenericAssert<AccessRuleAssert, AccessRule> {

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

        //TODO: We have to check the user list...against the
        //user in the AccessLevel ist.
        Boolean found = true;
        for (Access access : actual.getAccessList()) {
              if (access.getLevel() != level) {
                  found = false;
              }
        }


        return this;
    }

    public AccessRuleAssert and(String userName) {
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

        Access access = new Access();
        access.setPrincipal(UserFactory.createInstance(userName));

        Assertions.assertThat(actual.getAccessList().contains(access)).overridingErrorMessage(errorMessage).isTrue();
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

        Access access = new Access();
        access.setPrincipal(UserFactory.createInstance(userName));

        boolean result = actual.getAccessList().contains(access);

        String errorMessage = String.format(
                "Expected userName <%s> but it does not exist in list of users <%s> (<%s>)",
                userName,
                sb.toString(),
                result
        );

        Assertions.assertThat(actual.getAccessList().contains(access)).overridingErrorMessage(errorMessage).isTrue();

        userList.add(UserFactory.createInstance(userName));
//        Assertions.assertThat(actual.getAccessList())
//        .contains(userName)
//        .overridingErrorMessage("TEST");

        return this;
    }

}
