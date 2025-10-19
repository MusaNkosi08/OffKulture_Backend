package ac.za.cput.config;

import ac.za.cput.service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public AddressServiceImpl addressService() {
        return AddressServiceImpl.getService();
    }

    @Bean
    public CartItemServiceImpl cartItemService() {
        return CartItemServiceImpl.getService();
    }

    @Bean
    public OrderItemServiceImpl orderItemService() {
        return OrderItemServiceImpl.getService();
    }

    @Bean
    public OrderServiceImpl orderService() {
        return OrderServiceImpl.getService();
    }

    @Bean
    public ProductServiceImpl productService() {
        return ProductServiceImpl.getService();
    }

    @Bean
    public RoleServiceImpl roleService() {
        return RoleServiceImpl.getService();
    }

    @Bean
    public UserServiceImpl userService() {
        return UserServiceImpl.getService();
    }
}
