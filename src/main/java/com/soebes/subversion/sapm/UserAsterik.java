package com.soebes.subversion.sapm;

/**
 * This user is the user who represents anybody.
 * 
 * @author Karl Heinz Marbaise
 * 
 */
public class UserAsterik extends User {

    public UserAsterik() {
        super("*");
    }

    public boolean isEqual(String user) {
        return true;
    }

}
