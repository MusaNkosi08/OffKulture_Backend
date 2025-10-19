package ac.za.cput.service.impl;

import ac.za.cput.domain.OrderItem;
import ac.za.cput.repository.IOrderItemRepository;
import ac.za.cput.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements IOrderItemService {

    private final IOrderItemRepository repository;

    @Autowired
    public OrderItemServiceImpl(IOrderItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderItem create(OrderItem orderItem) {
        return this.repository.save(orderItem);
    }

    @Override
    public OrderItem read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public OrderItem update(OrderItem orderItem) {
        return this.repository.save(orderItem);
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
    public List<OrderItem> getAll() {
        return this.repository.findAll();
    }

    @Override
    public List<OrderItem> findByOrderId(String orderId) {
        return this.repository.findByOrderId(orderId);
    }
}
