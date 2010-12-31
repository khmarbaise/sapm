package com.soebes.subversion.sapm;

public class User implements IPrincipal {

	private String name;

	public User(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEqual(String user) {
		return getName().equals(user);
	}
	
}
