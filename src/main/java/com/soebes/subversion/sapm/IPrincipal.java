package com.soebes.subversion.sapm;

public interface IPrincipal {

    String getName();

    void setName(String name);

    boolean isEqual(String name);
}
