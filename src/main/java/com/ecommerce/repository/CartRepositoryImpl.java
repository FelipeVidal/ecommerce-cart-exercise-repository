package com.ecommerce.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Cart;

@Repository
public class CartRepositoryImpl implements CartRepository{

    @Autowired
    private CartJpaSpring cartJpaSpring;

    @Override
    public List<Cart> getAllCarts() {
        return cartJpaSpring.findAll();
    }

    @Override
    public Cart getCart(int id) {
        return cartJpaSpring.findById(id).orElse(null);
    }

    @Override
    public void addCart(Cart cart) {
        cartJpaSpring.save(cart);
    }

    @Override
    public void updateCart(Cart cart) {
        cartJpaSpring.save(cart);
    }

    @Override
    public void deleteCart(int id) {
        cartJpaSpring.deleteById(id);
    }

}
