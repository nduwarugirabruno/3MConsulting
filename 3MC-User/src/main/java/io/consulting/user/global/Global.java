package io.consulting.user.global;

public class Global {

    public static boolean invalidCreateUser(String name, Long number, String mail, String password, String skills) {
        if (name == null) {
            return true;
        }
        if (number == null) {
            return true;
        }
        if (mail == null) {
            return true;
        }
        if (password == null) {
            return true;
        }
        return skills == null;
    }

}
