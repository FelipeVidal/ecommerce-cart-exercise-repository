package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.Cart;

public interface CartService {
    List<Cart> getAllCarts();
    Cart getCart(int id);
    void addCart(Cart cart);
    void updateCart(Cart cart);
    void deleteCart(int id);
}
