package ac.za.cput.factory;

import ac.za.cput.domain.Order;
import ac.za.cput.domain.Order.OrderStatus;
import java.time.LocalDateTime;

/**
 * Factory for creating Order objects
 * @author Student
 */
public class OrderFactory {
    public static Order createOrder(String id, String userId, double totalPrice,
            String addressId) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Order ID is required");
        }
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID is required");
        }
        if (totalPrice < 0) {
            throw new IllegalArgumentException("Total price cannot be negative");
        }
        if (addressId == null || addressId.trim().isEmpty()) {
            throw new IllegalArgumentException("Address ID is required");
        }

        return new Order.Builder()
                .setId(id)
                .setUserId(userId)
                .setTotalPrice(totalPrice)
                .setAddressId(addressId)
                .setStatus(OrderStatus.PENDING)
                .setCreatedAt(LocalDateTime.now())
                .build();
    }

    public static Order createOrderWithPayment(String id, String userId,
            double totalPrice, String addressId, String paymentId,
            OrderStatus status) {
        if (paymentId == null || paymentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Payment ID is required");
        }
        if (status == null) {
            throw new IllegalArgumentException("Order status is required");
        }

        return new Order.Builder()
                .setId(id)
                .setUserId(userId)
                .setTotalPrice(totalPrice)
                .setAddressId(addressId)
                .setPaymentId(paymentId)
                .setStatus(status)
                .setCreatedAt(LocalDateTime.now())
                .build();
    }
}
