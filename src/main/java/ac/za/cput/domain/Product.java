package ac.za.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Product domain class implementing Builder pattern
 * @author Student
 */
@Entity
public class Product {
    @Id
    private String id;
    private String name;
    @Lob
    private String description;
    private double price;
    private int stock;
    private String categoryId;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "product_image_ids", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "image_id")
    private List<String> imageIds;
    private LocalDateTime createdAt;

    protected Product() {}

    private Product(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.stock = builder.stock;
        this.categoryId = builder.categoryId;
        this.imageIds = builder.imageIds;
        this.createdAt = builder.createdAt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public List<String> getImageIds() {
        return new ArrayList<>(imageIds); // Return a copy to maintain immutability
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && stock == product.stock && Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(categoryId, product.categoryId) && Objects.equals(imageIds, product.imageIds) && Objects.equals(createdAt, product.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, stock, categoryId, imageIds, createdAt);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", categoryId='" + categoryId + '\'' +
                ", imageIds=" + imageIds +
                ", createdAt=" + createdAt +
                '}';
    }

    public static class Builder {
        private String id;
        private String name;
        private String description;
        private double price;
        private int stock;
        private String categoryId;
        private List<String> imageIds = new ArrayList<>();
        private LocalDateTime createdAt;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setStock(int stock) {
            this.stock = stock;
            return this;
        }

        public Builder setCategoryId(String categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public Builder setImageIds(List<String> imageIds) {
            this.imageIds = new ArrayList<>(imageIds); // Create a copy to ensure immutability
            return this;
        }

        public Builder addImageId(String imageId) {
            this.imageIds.add(imageId);
            return this;
        }

        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder copy(Product product) {
            this.id = product.id;
            this.name = product.name;
            this.description = product.description;
            this.price = product.price;
            this.stock = product.stock;
            this.categoryId = product.categoryId;
            this.imageIds = new ArrayList<>(product.imageIds);
            this.createdAt = product.createdAt;
            return this;
        }

        public Product build() {
            if (createdAt == null) {
                createdAt = LocalDateTime.now(); // Set default creation time if not specified
            }
            return new Product(this);
        }
    }
}
