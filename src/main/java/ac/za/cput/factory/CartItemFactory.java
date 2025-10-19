package ac.za.cput.factory;

import ac.za.cput.domain.CartItem;

/**
 * Factory for creating CartItem objects
 * @author Student
 */
public class CartItemFactory {
    public static CartItem createCartItem(String id, String userId, String productId, int quantity) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Cart item ID is required");
        }
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID is required");
        }
        if (productId == null || productId.trim().isEmpty()) {
            throw new IllegalArgumentException("Product ID is required");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        return new CartItem.Builder()
                .setId(id)
                .setUserId(userId)
                .setProductId(productId)
                .setQuantity(quantity)
                .build();
    }
}
