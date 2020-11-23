package com.ecommerce.payment.entity;

import com.ecommerce.core.common.Price;
import com.ecommerce.core.order.payment.PaymentMode;
import com.ecommerce.core.order.payment.PaymentStatus;
import com.ecommerce.payment.processor.gateway.GatewayResponse;

import java.util.Map;

public class PaymentRecord {
    private String id;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private Map<String,String> paymentDetails;
    private Price amountForPayment;
    private GatewayResponse gatewayResponse;

    public String getId() {
        return id;
    }

    public PaymentRecord(String id,PaymentMode paymentMode, PaymentStatus paymentStatus, Map<String, String> paymentDetails, GatewayResponse gatewayResponse, Price amountForPayment) {
        this.id = id;
        this.paymentMode = paymentMode;
        this.paymentStatus = paymentStatus;
        this.paymentDetails = paymentDetails;
        this.gatewayResponse = gatewayResponse;
        this.amountForPayment = amountForPayment;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public Map<String, String> getPaymentDetails() {
        return paymentDetails;
    }

    public Price getAmountForPayment() {
        return amountForPayment;
    }

    public GatewayResponse getGatewayResponse() {
        return gatewayResponse;
    }
}
