package com.soebes.subversion.sapm;

public class UserFactory {

    public static User createInstance(String user) {
        if (user.equals("*")) {
            return new UserAsterik();
        } else {
            return new User(user);
        }
    }
}
