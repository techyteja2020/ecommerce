package com.ecommerce.core.customer;

import com.ecommerce.core.common.Price;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    private String id;
    private String cartId;
    private String productId;
    private Price price;
}
