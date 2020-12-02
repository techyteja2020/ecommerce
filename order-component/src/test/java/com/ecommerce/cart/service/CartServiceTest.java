package com.ecommerce.cart.service;

import com.ecommerce.cart.repository.CartRepository;
import com.ecommerce.core.common.Price;
import com.ecommerce.core.customer.CartItem;
import com.ecommerce.core.order.cart.Cart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CartServiceTest {
    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private CartService cartService;

    @Test
    public void shouldAddProductToCartAndReturnCartId(){
        String customerId = "cus001";
        String cartId = "cartId";
        Price price = new Price(2000, "INR");
        CartItem cartItem = CartItem.builder()
                .cartId(cartId)
                .id(cartId)
                .price(price)
                .productId("pro001")
                .build();
        Cart cart = mock(Cart.class);
        when(cartRepository.save(any(), any())).thenReturn(cart);
        when(cart.getCartId()).thenReturn("cartId");

        String actualCartId = cartService.addProduct(cartItem, cartId, customerId);
        assertEquals(cartId, actualCartId);
    }
}
