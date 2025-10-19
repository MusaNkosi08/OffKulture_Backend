package ac.za.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.util.Objects;

/**
 * OrderItem domain class implementing Builder pattern
 * @author Student
 */
@Entity
public class OrderItem {
    @Id
    private String id;
    private String orderId;
    private String productId;
    private int quantity;
    private double unitPrice;

    protected OrderItem() {}

    private OrderItem(Builder builder) {
        this.id = builder.id;
        this.orderId = builder.orderId;
        this.productId = builder.productId;
        this.quantity = builder.quantity;
        this.unitPrice = builder.unitPrice;
    }

    public String getId() {
        return id;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    @Transient
    public double getSubtotal() {
        return quantity * unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return quantity == orderItem.quantity && Double.compare(orderItem.unitPrice, unitPrice) == 0 && Objects.equals(id, orderItem.id) && Objects.equals(orderId, orderItem.orderId) && Objects.equals(productId, orderItem.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, productId, quantity, unitPrice);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id='" + id + '\'' +
                ", orderId='" + orderId + '\'' +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", subtotal=" + getSubtotal() +
                '}';
    }

    public static class Builder {
        private String id;
        private String orderId;
        private String productId;
        private int quantity;
        private double unitPrice;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public Builder copy(OrderItem orderItem) {
            this.id = orderItem.id;
            this.orderId = orderItem.orderId;
            this.productId = orderItem.productId;
            this.quantity = orderItem.quantity;
            this.unitPrice = orderItem.unitPrice;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }
    }
}
