package ac.za.cput.controller;

import ac.za.cput.domain.Order;
import ac.za.cput.factory.OrderFactory;
import ac.za.cput.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final IOrderService orderService;

    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public Order create(@RequestBody Order order) {
        Order newOrder = OrderFactory.createOrder(order.getUserId(), order.getTotalPrice(), order.getAddressId());
        return orderService.create(newOrder);
    }

    @GetMapping("/read/{id}")
    public Order read(@PathVariable String id) {
        return orderService.read(id);
    }

    @PutMapping("/update")
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return orderService.delete(id);
    }

    @GetMapping("/getall")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/findbyuserid/{userId}")
    public List<Order> findByUserId(@PathVariable String userId) {
        return orderService.findByUserId(userId);
    }
}
