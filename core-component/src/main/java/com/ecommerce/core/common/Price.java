package com.ecommerce.core.common;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Price {
    private double amount;
    private String currency;
}
