package ac.za.cput.service;

import ac.za.cput.domain.OrderItem;
import java.util.List;

public interface IOrderItemService extends IService<OrderItem, String> {
    List<OrderItem> findByOrderId(String orderId);
}
