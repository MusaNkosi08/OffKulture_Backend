package ac.za.cput.factory;

import ac.za.cput.domain.CartItem;
import ac.za.cput.util.Helper;

/**
 * Factory for creating CartItem objects
 * @author Student
 */
public class CartItemFactory {
    public static CartItem createCartItem(String userId, String productId, int quantity) {
        if (Helper.isNullOrEmpty(userId)) {
            throw new IllegalArgumentException("User ID is required");
        }
        if (Helper.isNullOrEmpty(productId)) {
            throw new IllegalArgumentException("Product ID is required");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        String cartItemId = Helper.generateId();

        return new CartItem.Builder()
                .setId(cartItemId)
                .setUserId(userId)
                .setProductId(productId)
                .setQuantity(quantity)
                .build();
    }
}
