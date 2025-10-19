package ac.za.cput.factory;

import ac.za.cput.domain.OrderItem;

/**
 * OrderItemFactory.java
 * Factory for creating OrderItem objects using the Builder pattern.
 * Author: Gcina Mbabe
 * Date: 18 October 2025
 */
public class OrderItemFactory {

    public static OrderItem createOrderItem(String itemId, String orderId, String productId, int quantity, double price) {
        if (itemId == null || itemId.isEmpty())
            throw new IllegalArgumentException("Item ID cannot be null or empty");
        if (orderId == null || orderId.isEmpty())
            throw new IllegalArgumentException("Order ID cannot be null or empty");
        if (productId == null || productId.isEmpty())
            throw new IllegalArgumentException("Product ID cannot be null or empty");
        if (quantity <= 0)
            throw new IllegalArgumentException("Quantity must be greater than zero");
        if (price < 0)
            throw new IllegalArgumentException("Price cannot be negative");

        return new OrderItem.Builder()
                .setId(itemId)
                .setOrderId(orderId)
                .setProductId(productId)
                .setQuantity(quantity)
                .setUnitPrice(price)
                .build();
    }
}
