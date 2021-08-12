package cz.vutbr.feec.fpga.services;

public class AuthService {

    private static final String username = "krypto";
    private static final String password = "krypto";

    public AuthService() {
    }

    public boolean authenticate(String username, String password) {
        if (username == null || username.isEmpty()) {
            return false;
        } else if (password == null || password.isEmpty()) {
            return false;
        }
        if (username.equals(this.username) && password.equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }
}
