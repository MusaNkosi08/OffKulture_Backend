package ac.za.cput.repository;

import ac.za.cput.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAddressRepository extends JpaRepository<Address, String> {
    List<Address> findByCity(String city);
}
