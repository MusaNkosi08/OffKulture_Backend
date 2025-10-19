package ac.za.cput.factory;

import ac.za.cput.domain.User;
import ac.za.cput.util.Helper;

public class UserFactory {

    public static User createUser(String firstName, String lastName, String email, String password, String roleId, String address) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password) || Helper.isNullOrEmpty(roleId) || Helper.isNullOrEmpty(address)) {
            throw new IllegalArgumentException("All fields are required");
        }

        if (!Helper.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }

        String userId = Helper.generateId();

        return new User.Builder()
                .setId(userId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password) // Note: In a real application, hash the password
                .setRoleId(roleId)
                .setAddress(address)
                .build();
    }
}
