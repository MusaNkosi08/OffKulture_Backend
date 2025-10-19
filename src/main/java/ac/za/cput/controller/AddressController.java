package ac.za.cput.controller;

import ac.za.cput.domain.Address;
import ac.za.cput.factory.AddressFactory;
import ac.za.cput.service.IAddressService;
import ac.za.cput.service.impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private IAddressService addressService;

    @PostMapping("/create")
    public Address create(@RequestBody Address address) {
        Address newAddress = AddressFactory.createAddress(address.getStreet(), address.getCity(), address.getPostalCode(), address.getCountry(), address.getUserId());
        return addressService.create(newAddress);
    }

    @GetMapping("/read/{id}")
    public Address read(@PathVariable String id) {
        return addressService.read(id);
    }

    @PutMapping("/update")
    public Address update(@RequestBody Address address) {
        return addressService.update(address);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return addressService.delete(id);
    }

    @GetMapping("/getall")
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @GetMapping("/findbycity/{city}")
    public List<Address> findByCity(@PathVariable String city) {
        return addressService.findByCity(city);
    }
}
