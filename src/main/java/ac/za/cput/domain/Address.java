
package ac.za.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Objects;

/**
 * Address domain class implementing Builder pattern
 * @author Student
 */
@Entity
public class Address {
    @Id
    private String id;
    private String street;
    private String city;
    private String postalCode;
    private String country;
    private String userId;

    protected Address() {}

    private Address(Builder builder) {
        this.id = builder.id;
        this.street = builder.street;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
        this.country = builder.country;
        this.userId = builder.userId;
    }

    public String getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(postalCode, address.postalCode) && Objects.equals(country, address.country) && Objects.equals(userId, address.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, city, postalCode, country, userId);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String street;
        private String city;
        private String postalCode;
        private String country;
        private String userId;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder copy(Address address) {
            this.id = address.id;
            this.street = address.street;
            this.city = address.city;
            this.postalCode = address.postalCode;
            this.country = address.country;
            this.userId = address.userId;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
