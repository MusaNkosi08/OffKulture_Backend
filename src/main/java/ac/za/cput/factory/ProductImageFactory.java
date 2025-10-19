package ac.za.cput.factory;

import ac.za.cput.domain.ProductImage;

/**
 * Factory for creating ProductImage objects
 * @author Student
 */
public class ProductImageFactory {
    public static ProductImage createProductImage(String id, String imageUrl, String productId) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Image ID is required");
        }
        if (imageUrl == null || imageUrl.trim().isEmpty()) {
            throw new IllegalArgumentException("Image URL is required");
        }
        if (productId == null || productId.trim().isEmpty()) {
            throw new IllegalArgumentException("Product ID is required");
        }

        return new ProductImage.Builder()
                .setId(id)
                .setImageUrl(imageUrl)
                .setProductId(productId)
                .build();
    }
}
