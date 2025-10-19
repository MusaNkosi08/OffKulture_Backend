package ac.za.cput.service;

import ac.za.cput.domain.Order;
import java.util.List;

public interface IOrderService extends IService<Order, String> {
    List<Order> findByUserId(String userId);
}
