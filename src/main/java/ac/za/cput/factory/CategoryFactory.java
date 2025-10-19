package ac.za.cput.factory;

import ac.za.cput.domain.Category;

/**
 * Factory for creating Category objects
 * @author Student
 */
public class CategoryFactory {
    public static Category createCategory(String id, String name, String description) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Category ID is required");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Category name is required");
        }

        return new Category.Builder()
                .setId(id)
                .setName(name)
                .setDescription(description)
                .build();
    }
}
