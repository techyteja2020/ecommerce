package com.ecommerce.core.customer;

import com.ecommerce.core.common.Price;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartItem {
    private String id;
    private String cartId;
    private String productId;
    private Price price;
}
