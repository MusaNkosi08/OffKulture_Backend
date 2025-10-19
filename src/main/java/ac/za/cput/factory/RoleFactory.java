package ac.za.cput.factory;

import ac.za.cput.domain.Role;
import ac.za.cput.util.Helper;

/**
 *
 * @author Student
 */
public class RoleFactory {
    public static Role createRole(String name) {
        if (Helper.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        String roleId = Helper.generateId();

        return new Role.Builder()
                .setId(roleId)
                .setName(name)
                .build();
    }
}
