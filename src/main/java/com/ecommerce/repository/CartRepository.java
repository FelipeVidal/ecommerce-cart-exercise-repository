package com.ecommerce.repository;

import java.util.List;

import com.ecommerce.model.Cart;

public interface CartRepository {
    List<Cart> getAllCarts();
    Cart getCart(int id);
    void addCart(Cart cart);
    void updateCart(Cart cart);
    void deleteCart(int id);
}
