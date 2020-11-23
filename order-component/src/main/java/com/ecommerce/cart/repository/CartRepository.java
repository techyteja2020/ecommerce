package com.ecommerce.cart.repository;

import com.ecommerce.core.order.cart.Cart;
import com.ecommerce.core.CustomRepository;
import org.springframework.stereotype.Component;

@Component
public class CartRepository extends CustomRepository<Cart> {

    public Cart save(String id, Cart cart) {
        return super.save(id, cart);
    }

    public Cart getById(String cartId) {
        return super.findOne(cartId);
    }
}
