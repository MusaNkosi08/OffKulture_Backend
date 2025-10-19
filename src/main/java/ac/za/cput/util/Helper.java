package ac.za.cput.util;

import java.util.UUID;
import org.apache.commons.validator.routines.EmailValidator;

public class Helper {
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static boolean isValidEmail(String email) {
        return EmailValidator.getInstance().isValid(email);
    }
}
