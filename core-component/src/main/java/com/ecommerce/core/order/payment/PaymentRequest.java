package com.ecommerce.core.order.payment;

import com.ecommerce.core.common.Price;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    private PaymentMode paymentMode;
    private Price billAmount;
    private Map<String,String> paymentDetails;
    private String id;

}


