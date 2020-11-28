package com.ecommerce.cart.service;

import com.ecommerce.cart.repository.CartRepository;
import com.ecommerce.core.customer.CartItem;
import com.ecommerce.core.order.cart.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public String addProduct(CartItem cartItem, String cartId, String customerId) {
        Cart cart = Cart.builder()
                .id(cartItem.getId())
                .cartId(cartId)
                .customerId(customerId)
                .price(cartItem.getPrice())
                .productId(cartItem.getProductId())
                .build();
        Cart savedCart = cartRepository.save(cartId, cart);
        return savedCart.getCartId();
    }
}
