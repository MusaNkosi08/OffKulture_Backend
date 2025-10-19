package ac.za.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Order domain class implementing Builder pattern
 * @author Student
 */
@Entity
@Table(name = "orders")
public class Order {
    public enum OrderStatus {
        PENDING,
        PROCESSING,
        SHIPPED,
        DELIVERED,
        CANCELLED
    }

    @Id
    private String id;
    private String userId;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private double totalPrice;
    private LocalDateTime createdAt;
    private String addressId;
    private String paymentId;

    protected Order() {}

    private Order(Builder builder) {
        this.id = builder.id;
        this.userId = builder.userId;
        this.status = builder.status;
        this.totalPrice = builder.totalPrice;
        this.createdAt = builder.createdAt;
        this.addressId = builder.addressId;
        this.paymentId = builder.paymentId;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getAddressId() {
        return addressId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.totalPrice, totalPrice) == 0 && Objects.equals(id, order.id) && Objects.equals(userId, order.userId) && status == order.status && Objects.equals(createdAt, order.createdAt) && Objects.equals(addressId, order.addressId) && Objects.equals(paymentId, order.paymentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, status, totalPrice, createdAt, addressId, paymentId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", status=" + status +
                ", totalPrice=" + totalPrice +
                ", createdAt=" + createdAt +
                ", addressId='" + addressId + '\'' +
                ", paymentId='" + paymentId + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String userId;
        private OrderStatus status = OrderStatus.PENDING; // Default status
        private double totalPrice;
        private LocalDateTime createdAt;
        private String addressId;
        private String paymentId;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setStatus(OrderStatus status) {
            this.status = status;
            return this;
        }

        public Builder setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setAddressId(String addressId) {
            this.addressId = addressId;
            return this;
        }

        public Builder setPaymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder copy(Order order) {
            this.id = order.id;
            this.userId = order.userId;
            this.status = order.status;
            this.totalPrice = order.totalPrice;
            this.createdAt = order.createdAt;
            this.addressId = order.addressId;
            this.paymentId = order.paymentId;
            return this;
        }

        public Order build() {
            if (createdAt == null) {
                createdAt = LocalDateTime.now(); // Set default creation time if not specified
            }
            return new Order(this);
        }
    }
}
