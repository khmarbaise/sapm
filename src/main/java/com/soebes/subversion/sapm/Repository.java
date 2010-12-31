package com.soebes.subversion.sapm;

import java.util.ArrayList;

public class Repository {

	private String name; //Which repository
	
	private ArrayList<String> paths = new ArrayList<String>();
	
	public Repository(String name) {
		super();
		this.name = name;
	}

	public Repository(String name, String path) {
		super();
		this.name = name;
		this.paths.add(path);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getPaths() {
		return paths;
	}

	public void setPaths(ArrayList<String> paths) {
		this.paths = paths;
	}
	
	public void addPath(String path) {
		this.paths.add(path);
	}
}
