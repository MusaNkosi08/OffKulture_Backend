package ac.za.cput.controller;

import ac.za.cput.domain.CartItem;
import ac.za.cput.factory.CartItemFactory;
import ac.za.cput.service.ICartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartitem")
public class CartItemController {

    @Autowired
    private ICartItemService cartItemService;

    @PostMapping("/create")
    public CartItem create(@RequestBody CartItem cartItem) {
        CartItem newCartItem = CartItemFactory.createCartItem(cartItem.getUserId(), cartItem.getProductId(), cartItem.getQuantity());
        return cartItemService.create(newCartItem);
    }

    @GetMapping("/read/{id}")
    public CartItem read(@PathVariable String id) {
        return cartItemService.read(id);
    }

    @PutMapping("/update")
    public CartItem update(@RequestBody CartItem cartItem) {
        return cartItemService.update(cartItem);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return cartItemService.delete(id);
    }

    @GetMapping("/getall")
    public List<CartItem> getAll() {
        return cartItemService.getAll();
    }

    @GetMapping("/findbyuserid/{userId}")
    public List<CartItem> findByUserId(@PathVariable String userId) {
        return cartItemService.findByUserId(userId);
    }
}
