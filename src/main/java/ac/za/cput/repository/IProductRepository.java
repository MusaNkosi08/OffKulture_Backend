package ac.za.cput.repository;

import ac.za.cput.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, String> {
    // No custom methods needed for now
}
