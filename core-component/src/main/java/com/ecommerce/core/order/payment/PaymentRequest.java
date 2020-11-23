package com.ecommerce.core.order.payment;

import com.ecommerce.core.common.Price;

import java.util.Map;

public class PaymentRequest {
    private PaymentMode paymentMode;
    private Price billAmount;
    private Map<String,String> paymentDetails;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Price getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Price billAmount) {
        this.billAmount = billAmount;
    }

    public Map<String, String> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(Map<String, String> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

}


