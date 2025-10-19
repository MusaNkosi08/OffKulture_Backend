package ac.za.cput.service.impl;

import ac.za.cput.domain.Address;
import ac.za.cput.repository.IAddressRepository;
import ac.za.cput.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {

    private final IAddressRepository repository;

    @Autowired
    public AddressServiceImpl(IAddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public Address create(Address address) {
        return this.repository.save(address);
    }

    @Override
    public Address read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Address update(Address address) {
        return this.repository.save(address);
    }

    @Override
    public boolean delete(String id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Address> getAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Address> findByCity(String city) {
        return this.repository.findByCity(city);
    }
}
