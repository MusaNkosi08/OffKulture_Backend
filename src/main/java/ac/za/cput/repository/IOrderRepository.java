package ac.za.cput.repository;

import ac.za.cput.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, String> {
    List<Order> findByUserId(String userId);
}
