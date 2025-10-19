package ac.za.cput.factory;

import ac.za.cput.domain.Product;
import ac.za.cput.util.Helper;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Factory for creating Product objects
 * @author Student
 */
public class ProductFactory {
    public static Product createProduct(String name, String description, double price, int stock, String categoryId, List<String> imageIds) {
        if (Helper.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Product name is required");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }

        String productId = Helper.generateId();

        return new Product.Builder()
                .setId(productId)
                .setName(name)
                .setDescription(description)
                .setPrice(price)
                .setStock(stock)
                .setCategoryId(categoryId)
                .setImageIds(imageIds)
                .setCreatedAt(LocalDateTime.now())
                .build();
    }
}
