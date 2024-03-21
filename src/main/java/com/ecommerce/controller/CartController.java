package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;
import com.ecommerce.service.CartService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CartController {
    
    private String url = "http://localhost:8000";

    @Autowired
    CartService cartService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "carts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }
    @GetMapping(value = "cart/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cart getCart(@PathParam("id") int id) {
        return cartService.getCart(id);
    }

    @PostMapping(value = "cart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCart(@RequestBody Cart cart) {
        cartService.addCart(cart);
    }

    @PostMapping(value = "addproduct/{idcart}/{sku}")
    public void addProduct(@PathVariable("idcart") int idCart, @PathVariable("sku") String sku) {
        Cart auxCart = new Cart();
        auxCart= cartService.getCart(idCart); //Obtengo el carrito a actualizar

        Product auxProduct = new Product();
        auxProduct = restTemplate.getForObject(url+"/product/"+sku, Product.class); //Obtengo el producto a añadir

        auxCart.getProducts().add(auxProduct); //Añado el nuevo producto

        cartService.updateCart(auxCart); //Actualizo el carrito

    }

    @DeleteMapping(value = "cart/{idCart}")
    public void deleteCart(@PathVariable("idCart")int idCart){
        cartService.deleteCart(idCart);
    }
    
    //@TODO: Método para borrar product
    

}
