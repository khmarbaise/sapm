package com.soebes.subversion.sapm;

public interface IReference {

	public enum RefType {
		User,
		Group,
		Alias
	}
	
	RefType isType();
	
	String getName();
}
