package cz.vutbr.feec.fpga.services;

public class AuthService {

    private static final String USERNAME_INITIAL_AUTH = "crypto";
    private static final String PASSWORD_INITIAL_AUTH = "crypto";

    public AuthService() {
    }

    public boolean authenticate(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return false;
        }
        return username.equals(USERNAME_INITIAL_AUTH) && password.equals(PASSWORD_INITIAL_AUTH);
    }

}
