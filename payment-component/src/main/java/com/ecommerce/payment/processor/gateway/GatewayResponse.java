package com.ecommerce.payment.processor.gateway;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GatewayResponse {
    private String paymentId;
    private String signature;
}
