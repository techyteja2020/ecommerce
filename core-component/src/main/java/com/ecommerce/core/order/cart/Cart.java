package com.ecommerce.core.order.cart;

import com.ecommerce.core.common.Price;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Cart {
    private String id;
    private String cartId;
    private String customerId;
    private String productId;
    private Price price;
}
