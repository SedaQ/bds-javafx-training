package cz.vutbr.feec.fpga.services;

public class AuthService {

    private static final String USERNAME_INITIAL_AUTH = "crypto";
    private static final String PASSWORD_INITIAL_AUTH = "crypto";

    public AuthService() {
    }

    public boolean authenticate(String username, String password) {
        if (username == null || username.isEmpty()) {
            return false;
        } else if (password == null || password.isEmpty()) {
            return false;
        }
        if (username.equals(this.USERNAME_INITIAL_AUTH) && password.equals(this.PASSWORD_INITIAL_AUTH)) {
            return true;
        } else {
            return false;
        }
    }
}
