package ac.za.cput.factory;

import ac.za.cput.domain.Order;
import ac.za.cput.domain.Order.OrderStatus;
import ac.za.cput.util.Helper;

import java.time.LocalDateTime;

/**
 * Factory for creating Order objects
 * @author Student
 */
public class OrderFactory {
    public static Order createOrder(String userId, double totalPrice, String addressId) {
        if (Helper.isNullOrEmpty(userId)) {
            throw new IllegalArgumentException("User ID is required");
        }
        if (totalPrice < 0) {
            throw new IllegalArgumentException("Total price cannot be negative");
        }
        if (Helper.isNullOrEmpty(addressId)) {
            throw new IllegalArgumentException("Address ID is required");
        }

        String orderId = Helper.generateId();

        return new Order.Builder()
                .setId(orderId)
                .setUserId(userId)
                .setTotalPrice(totalPrice)
                .setAddressId(addressId)
                .setStatus(OrderStatus.PENDING)
                .setCreatedAt(LocalDateTime.now())
                .build();
    }
}
