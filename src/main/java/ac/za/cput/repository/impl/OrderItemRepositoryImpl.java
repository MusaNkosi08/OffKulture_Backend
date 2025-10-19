package ac.za.cput.repository.impl;

import ac.za.cput.domain.OrderItem;
import ac.za.cput.repository.IOrderItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderItemRepositoryImpl implements IOrderItemRepository {

    private static OrderItemRepositoryImpl repository = null;
    private List<OrderItem> orderItemList;

    private OrderItemRepositoryImpl() {
        orderItemList = new ArrayList<>();
    }

    public static OrderItemRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new OrderItemRepositoryImpl();
        }
        return repository;
    }

    @Override
    public OrderItem create(OrderItem orderItem) {
        this.orderItemList.add(orderItem);
        return orderItem;
    }

    @Override
    public OrderItem read(String id) {
        return this.orderItemList.stream()
                .filter(orderItem -> orderItem.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public OrderItem update(OrderItem orderItem) {
        OrderItem toUpdate = read(orderItem.getId());
        if (toUpdate != null) {
            this.orderItemList.remove(toUpdate);
            this.orderItemList.add(orderItem);
            return orderItem;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        OrderItem toDelete = read(id);
        if (toDelete != null) {
            this.orderItemList.remove(toDelete);
            return true;
        }
        return false;
    }

    @Override
    public List<OrderItem> getAll() {
        return this.orderItemList;
    }

    @Override
    public List<OrderItem> findByOrderId(String orderId) {
        return this.orderItemList.stream()
                .filter(orderItem -> orderItem.getOrderId().equalsIgnoreCase(orderId))
                .collect(Collectors.toList());
    }
}
