package com.ecommerce.cart.service;

import com.ecommerce.core.customer.CartItem;
import com.ecommerce.core.order.cart.Cart;
import com.ecommerce.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public String addProduct(CartItem cartItem, String cartId, String customerId) {
        Cart cart = new Cart();
        cart.setId(cartItem.getId());
        cart.setCartId(cartId);
        cart.setCustomerId(customerId);
        cart.setPrice(cartItem.getPrice());
        cart.setProductId(cartItem.getProductId());
        cartRepository.save(cartId, cart);
        return cart.getCartId();
    }
}
