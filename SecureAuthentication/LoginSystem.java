
public class LoginSystem {

    public boolean login(String username, String password) {
        if (username == null || password == null)
            return false;

        if (username.length() < 3 || username.length() > 20)
            return false;

        if (password.length() < 6 || password.length() > 20)
            return false;

        return username.equals("admin")
                && password.equals("admin123");
    }
}
