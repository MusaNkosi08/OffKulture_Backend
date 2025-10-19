package ac.za.cput.repository;

import ac.za.cput.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICartItemRepository extends JpaRepository<CartItem, String> {
    List<CartItem> findByUserId(String userId);
}
