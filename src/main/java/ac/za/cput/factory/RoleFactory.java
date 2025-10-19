/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ac.za.cput.factory;

import ac.za.cput.domain.Role;

/**
 *
 * @author Student
 */
public class RoleFactory {
    public static Role createRole(String id, String name) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        return new Role.Builder()
                .setId(id)
                .setName(name)
                .build();
    }
}
