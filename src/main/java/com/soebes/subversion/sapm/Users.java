package com.soebes.subversion.sapm;

import java.util.ArrayList;

public class Users {

    private ArrayList<User> usersList;

    public Users() {
        setUsersList(new ArrayList<User>());
    }

    public void setUsersList(ArrayList<User> usersList) {
        this.usersList = usersList;
    }

    public ArrayList<User> getUsersList() {
        return usersList;
    }

    public void add(User user) {
        getUsersList().add(user);
    }

    public boolean hasUser(String userName) {
        boolean result = false;
        for (User item : getUsersList()) {
            if (item.getName().equals(userName)) {
                result = true;
            }
        }
        return result;
    }

    public User getUser(String userName) {
        User result = null;
        for (User item : getUsersList()) {
            if (item.getName().equals(userName)) {
                result = item;
            }
        }
        return result;
    }
}
