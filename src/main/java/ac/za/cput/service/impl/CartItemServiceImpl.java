package ac.za.cput.service.impl;

import ac.za.cput.domain.CartItem;
import ac.za.cput.repository.ICartItemRepository;
import ac.za.cput.service.ICartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements ICartItemService {

    private final ICartItemRepository repository;

    @Autowired
    public CartItemServiceImpl(ICartItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public CartItem create(CartItem cartItem) {
        return this.repository.save(cartItem);
    }

    @Override
    public CartItem read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public CartItem update(CartItem cartItem) {
        return this.repository.save(cartItem);
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
    public List<CartItem> getAll() {
        return this.repository.findAll();
    }

    @Override
    public List<CartItem> findByUserId(String userId) {
        return this.repository.findByUserId(userId);
    }
}
