package com.soebes.subversion.sapm;

import java.util.ArrayList;

public class Group implements IPrincipal {

	private ArrayList<User> userList;

	private String name;

	private void init() {
		setUserList(new ArrayList<User>());
	}

	public Group() {
		init();
	}

	public Group(String name) {
		setName(name);
		init();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void add(User user) {
		if (!getUserList().contains(user)) {
			getUserList().add(user);
		}
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public boolean contains(User user) {
		return contains(user.getName());
	}

	public boolean contains(String user) {
		boolean result = false;
		for (User item : getUserList()) {
//TODO: Check if the equalsIgnoreCase() is correct? 
			if (item.getName().equalsIgnoreCase(user)) {
				result = true;
			}
		}
		return result;
	}

	public boolean isEqual(User user) {
		return isEqual(user.getName());
	}

	public boolean isEqual(String user) {
		boolean result = false;
		for (User item : getUserList()) {
			if (item.isEqual(user)) {
				result = true;
			}
		}
		return result;
	}

}
