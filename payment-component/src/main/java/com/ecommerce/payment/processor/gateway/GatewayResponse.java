package com.ecommerce.payment.processor.gateway;

public class GatewayResponse {
    private String paymentId;
    private String signature;

    public GatewayResponse(String paymentId, String signature) {
        this.paymentId = paymentId;
        this.signature = signature;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getSignature() {
        return signature;
    }
}
