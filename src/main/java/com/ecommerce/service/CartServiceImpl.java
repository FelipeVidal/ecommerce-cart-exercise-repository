package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;
import com.ecommerce.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    CartRepository cartRepository;

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.getAllCarts();
    }

    @Override
    public Cart getCart(int id) {
        return cartRepository.getCart(id);
    }

    @Override
    public void addCart(Cart cart) {
        updatePriceCart(cart);
        cartRepository.addCart(cart);      
    }

    @Override
    public void updateCart(Cart cart) {
        updatePriceCart(cart);
        cartRepository.addCart(cart);
    }

    @Override
    public void deleteCart(int id) {
        cartRepository.deleteCart(id);
    }

    private void updatePriceCart(Cart cart){
        if(cart.getProducts().size()>0){
            for(Product product: cart.getProducts()){
                cart.setPriceTotal(cart.getPriceTotal()+product.getPrice());
            }          
        }
    }
}
