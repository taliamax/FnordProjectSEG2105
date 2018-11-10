package slng.fnord;

import java.security.SecureRandom;

public class User {
    private String email;
    private String username;
    private String passwordHash;
    private String salt;
    private UserTypes type;

    public User (String email, String username, String password, UserTypes type) {
        this.email = email;
        this.username = username;
        byte[] saltBytes = new byte[20];
        SecureRandom scrand = new SecureRandom();
        scrand.nextBytes(saltBytes);
        salt = Common.makeHex(saltBytes);
        passwordHash = Common.makeMD5(password + salt);
        this.type = type;
    }

    public boolean checkPassword (String password) {
        return Common.makeMD5(password + salt).equalsIgnoreCase(passwordHash);
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
}
