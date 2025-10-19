/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ac.za.cput.domain;

/**
 * ProductImage domain class implementing Builder pattern
 * @author Student
 */
public class ProductImage {
    private final String id;
    private final String imageUrl;
    private final String productId;  // Reference to the product

    private ProductImage(Builder builder) {
        this.id = builder.id;
        this.imageUrl = builder.imageUrl;
        this.productId = builder.productId;
    }

    public String getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "id='" + id + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", productId='" + productId + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String imageUrl;
        private String productId;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder copy(ProductImage productImage) {
            this.id = productImage.id;
            this.imageUrl = productImage.imageUrl;
            this.productId = productImage.productId;
            return this;
        }

        public ProductImage build() {
            return new ProductImage(this);
        }
    }
}
