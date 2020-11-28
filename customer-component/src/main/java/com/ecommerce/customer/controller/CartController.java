package com.ecommerce.customer.controller;

import com.ecommerce.cart.service.CartService;
import com.ecommerce.core.customer.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/")
public class CartController {

    @Autowired
    private CartService cartService;

    @PutMapping(path = "customers/{customerId}/carts/{cartId}/add")
    public ResponseEntity addToCart(@RequestBody CartItem cartItem,
                                    @PathVariable("customerId") String customerId,
                                    @PathVariable("cartId") String cartId) {
        cartService.addProduct(cartItem, cartId, customerId);
        return new ResponseEntity(cartId, HttpStatus.OK);
    }
}
