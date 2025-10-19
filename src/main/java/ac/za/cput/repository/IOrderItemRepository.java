package ac.za.cput.repository;

import ac.za.cput.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderItemRepository extends JpaRepository<OrderItem, String> {
    List<OrderItem> findByOrderId(String orderId);
}
