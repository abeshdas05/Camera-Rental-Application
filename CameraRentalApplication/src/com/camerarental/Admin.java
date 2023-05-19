package com.camerarental;

public class Admin {
    String userName = "admin";
    String password = "admin123";

    boolean accountVerify ( String userName, String password ) {
        if ( userName.equals ( this.userName ) && password.equals ( this.password ) ) {
            return true;
        }
        return false;
    }
}
