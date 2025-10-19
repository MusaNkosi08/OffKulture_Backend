package ac.za.cput.service;

import ac.za.cput.domain.Address;
import java.util.List;

public interface IAddressService extends IService<Address, String> {
    List<Address> findByCity(String city);
}
