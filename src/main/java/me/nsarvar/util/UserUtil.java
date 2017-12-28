package me.nsarvar.util;

/**
 * Created by nsarvar on 12/27/17.
 */
public class UserUtil {
    private UserUtil() {}

    public static String convertToFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
}
