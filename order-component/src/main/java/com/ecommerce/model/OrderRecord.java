package com.ecommerce.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderRecord {
    private String id;
    private String customerId;
    private String paymentTxnid;
    private String cartId;
    private String billToAddressId;
    private String shipToAddressId;
    private String paymentRecordId;

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(String customerId) {
//        this.customerId = customerId;
//    }
//
//    public String getCartId() {
//        return cartId;
//    }
//
//    public void setCartId(String cartId) {
//        this.cartId = cartId;
//    }
//
//    public String getBillToAddressId() {
//        return billToAddressId;
//    }
//
//    public void setBillToAddressId(String billToAddressId) {
//        this.billToAddressId = billToAddressId;
//    }
//
//    public String getShipToAddressId() {
//        return shipToAddressId;
//    }
//
//    public void setShipToAddressId(String shipToAddressId) {
//        this.shipToAddressId = shipToAddressId;
//    }
//
//    public String getPaymentTxnid() {
//        return paymentTxnid;
//    }
//
//    public void setPaymentTxnid(String paymentTxnid) {
//        this.paymentTxnid = paymentTxnid;
//    }
//
//    public String getPaymentRecordId() {
//        return paymentRecordId;
//    }
//
//    public void setPaymentRecordId(String paymentRecordId) {
//        this.paymentRecordId = paymentRecordId;
//    }
}
