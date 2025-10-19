package ac.za.cput.factory;

import ac.za.cput.domain.Address;
import ac.za.cput.util.Helper;

/**
 * Factory for creating Address objects
 * @author Student
 */
public class AddressFactory {
    public static Address createAddress(String street, String city,
            String postalCode, String country, String userId) {

        if (Helper.isNullOrEmpty(street)) {
            throw new IllegalArgumentException("Street is required");
        }
        if (Helper.isNullOrEmpty(city)) {
            throw new IllegalArgumentException("City is required");
        }
        if (Helper.isNullOrEmpty(postalCode)) {
            throw new IllegalArgumentException("Postal code is required");
        }
        if (Helper.isNullOrEmpty(country)) {
            throw new IllegalArgumentException("Country is required");
        }
        if (Helper.isNullOrEmpty(userId)) {
            throw new IllegalArgumentException("User ID is required");
        }

        String addressId = Helper.generateId();

        return new Address.Builder()
                .setId(addressId)
                .setStreet(street)
                .setCity(city)
                .setPostalCode(postalCode)
                .setCountry(country)
                .setUserId(userId)
                .build();
    }
}
