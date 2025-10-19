package ac.za.cput.factory;

import ac.za.cput.domain.Product;
import java.util.ArrayList;
import java.util.List;

/**
 * Factory for creating Product objects
 * @author Student
 */
public class ProductFactory {
    public static Product createProduct(String id, String name, String description,
            double price, int stock, String categoryId) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Product ID is required");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name is required");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }

        return new Product.Builder()
                .setId(id)
                .setName(name)
                .setDescription(description)
                .setPrice(price)
                .setStock(stock)
                .setCategoryId(categoryId)
                .build();
    }

    public static Product createProductWithImages(String id, String name,
            String description, double price, int stock,
            String categoryId, List<String> imageIds) {
        Product product = createProduct(id, name, description, price, stock, categoryId);
        return new Product.Builder()
                .copy(product)
                .setImageIds(imageIds != null ? imageIds : new ArrayList<>())
                .build();
    }
}
