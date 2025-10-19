package ac.za.cput.repository.impl;

import ac.za.cput.domain.Address;
import ac.za.cput.repository.IAddressRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddressRepositoryImpl implements IAddressRepository {

    private static AddressRepositoryImpl repository = null;
    private List<Address> addressList;

    private AddressRepositoryImpl() {
        addressList = new ArrayList<>();
    }

    public static AddressRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new AddressRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Address create(Address address) {
        this.addressList.add(address);
        return address;
    }

    @Override
    public Address read(String id) {
        return this.addressList.stream()
                .filter(address -> address.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Address update(Address address) {
        Address toUpdate = read(address.getId());
        if (toUpdate != null) {
            this.addressList.remove(toUpdate);
            this.addressList.add(address);
            return address;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Address toDelete = read(id);
        if (toDelete != null) {
            this.addressList.remove(toDelete);
            return true;
        }
        return false;
    }

    @Override
    public List<Address> getAll() {
        return this.addressList;
    }

    @Override
    public List<Address> findByCity(String city) {
        return this.addressList.stream()
                .filter(address -> address.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }
}
