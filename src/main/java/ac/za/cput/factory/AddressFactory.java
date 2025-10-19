package ac.za.cput.factory;

import ac.za.cput.domain.Address;

/**
 * Factory for creating Address objects
 * @author Student
 */
public class AddressFactory {
    public static Address createAddress(String id, String street, String city,
            String postalCode, String country, String userId) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Address ID is required");
        }
        if (street == null || street.trim().isEmpty()) {
            throw new IllegalArgumentException("Street is required");
        }
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City is required");
        }
        if (postalCode == null || postalCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Postal code is required");
        }
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("Country is required");
        }
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID is required");
        }

        return new Address.Builder()
                .setId(id)
                .setStreet(street)
                .setCity(city)
                .setPostalCode(postalCode)
                .setCountry(country)
                .setUserId(userId)
                .build();
    }
}
