package com.ecommerce.payment.entity;

import com.ecommerce.core.common.Price;
import com.ecommerce.core.order.payment.PaymentMode;
import com.ecommerce.core.order.payment.PaymentStatus;
import com.ecommerce.payment.processor.gateway.GatewayResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class PaymentRecord {
    private String id;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private Map<String,String> paymentDetails;
    private Price amountForPayment;
    private GatewayResponse gatewayResponse;
}
