package ac.za.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Objects;

/**
 * CartItem domain class implementing Builder pattern
 * @author Student
 */
@Entity
public class CartItem {
    @Id
    private String id;
    private String userId;
    private String productId;
    private int quantity;

    protected CartItem() {}

    private CartItem(Builder builder) {
        this.id = builder.id;
        this.userId = builder.userId;
        this.productId = builder.productId;
        this.quantity = builder.quantity;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return quantity == cartItem.quantity && Objects.equals(id, cartItem.id) && Objects.equals(userId, cartItem.userId) && Objects.equals(productId, cartItem.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, productId, quantity);
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public static class Builder {
        private String id;
        private String userId;
        private String productId;
        private int quantity;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setUserId(String userId) {
            this.userId = userId;
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

        public Builder copy(CartItem cartItem) {
            this.id = cartItem.id;
            this.userId = cartItem.userId;
            this.productId = cartItem.productId;
            this.quantity = cartItem.quantity;
            return this;
        }

        public CartItem build() {
            return new CartItem(this);
        }
    }
}
