package com.soebes.subversion.sapm;

public class Access {

    private IPrincipal principal;
    private AccessLevel level;

    public Access() {
        setPrincipal(null);
        setLevel(AccessLevel.NOTHING);
    }

    public Access(IPrincipal principal, AccessLevel level) {
        super();
        setPrincipal(principal);
        setLevel(level);
    }

    public IPrincipal getPrincipal() {
        return principal;
    }

    public void setPrincipal(IPrincipal principal) {
        this.principal = principal;
    }

    public AccessLevel getLevel() {
        return level;
    }

    public void setLevel(AccessLevel level) {
        this.level = level;
    }
}
