package ac.za.cput.repository.impl;

import ac.za.cput.domain.CartItem;
import ac.za.cput.repository.ICartItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartItemRepositoryImpl implements ICartItemRepository {

    private static CartItemRepositoryImpl repository = null;
    private List<CartItem> cartItemList;

    private CartItemRepositoryImpl() {
        cartItemList = new ArrayList<>();
    }

    public static CartItemRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new CartItemRepositoryImpl();
        }
        return repository;
    }

    @Override
    public CartItem create(CartItem cartItem) {
        this.cartItemList.add(cartItem);
        return cartItem;
    }

    @Override
    public CartItem read(String id) {
        return this.cartItemList.stream()
                .filter(cartItem -> cartItem.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public CartItem update(CartItem cartItem) {
        CartItem toUpdate = read(cartItem.getId());
        if (toUpdate != null) {
            this.cartItemList.remove(toUpdate);
            this.cartItemList.add(cartItem);
            return cartItem;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        CartItem toDelete = read(id);
        if (toDelete != null) {
            this.cartItemList.remove(toDelete);
            return true;
        }
        return false;
    }

    @Override
    public List<CartItem> getAll() {
        return this.cartItemList;
    }

    @Override
    public List<CartItem> findByUserId(String userId) {
        return this.cartItemList.stream()
                .filter(cartItem -> cartItem.getUserId().equalsIgnoreCase(userId))
                .collect(Collectors.toList());
    }
}
