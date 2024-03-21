package com.ecommerce.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cart_id;
    private float priceTotal;
    
    @OneToMany
    private List<Product> products;


    public Cart(int cart_id, List<Product> products, float priceTotal){
        this.cart_id = cart_id;
        this.products = products;
        this.priceTotal = priceTotal;
    }

    public Cart(){}

    public void setId(int cart_id){
        this.cart_id = cart_id;
    }

    public int getId(){
        return cart_id;
    }

    public void setProducts(List<Product> products){
        this.products = products;
    }

    public List<Product> getProducts(){
        return products;
    }

    public void setPriceTotal(float priceTotal){
        this.priceTotal = priceTotal;
    }

    public float getPriceTotal(){
        return priceTotal;
    }
}
