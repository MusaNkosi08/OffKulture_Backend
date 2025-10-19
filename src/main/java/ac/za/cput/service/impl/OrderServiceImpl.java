package ac.za.cput.service.impl;

import ac.za.cput.domain.Order;
import ac.za.cput.repository.IOrderRepository;
import ac.za.cput.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository repository;

    @Autowired
    public OrderServiceImpl(IOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order create(Order order) {
        return this.repository.save(order);
    }

    @Override
    public Order read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Order update(Order order) {
        return this.repository.save(order);
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
    public List<Order> getAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Order> findByUserId(String userId) {
        return this.repository.findByUserId(userId);
    }
}
