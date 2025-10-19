package ac.za.cput.repository.impl;

import ac.za.cput.domain.Order;
import ac.za.cput.repository.IOrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderRepositoryImpl implements IOrderRepository {

    private static OrderRepositoryImpl repository = null;
    private List<Order> orderList;

    private OrderRepositoryImpl() {
        orderList = new ArrayList<>();
    }

    public static OrderRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new OrderRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Order create(Order order) {
        this.orderList.add(order);
        return order;
    }

    @Override
    public Order read(String id) {
        return this.orderList.stream()
                .filter(order -> order.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Order update(Order order) {
        Order toUpdate = read(order.getId());
        if (toUpdate != null) {
            this.orderList.remove(toUpdate);
            this.orderList.add(order);
            return order;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Order toDelete = read(id);
        if (toDelete != null) {
            this.orderList.remove(toDelete);
            return true;
        }
        return false;
    }

    @Override
    public List<Order> getAll() {
        return this.orderList;
    }

    @Override
    public List<Order> findByUserId(String userId) {
        return this.orderList.stream()
                .filter(order -> order.getUserId().equalsIgnoreCase(userId))
                .collect(Collectors.toList());
    }
}
