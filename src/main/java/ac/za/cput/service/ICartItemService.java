package ac.za.cput.service;

import ac.za.cput.domain.CartItem;
import java.util.List;

public interface ICartItemService extends IService<CartItem, String> {
    List<CartItem> findByUserId(String userId);
}
