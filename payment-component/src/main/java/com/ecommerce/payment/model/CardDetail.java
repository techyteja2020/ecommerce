package com.ecommerce.payment.model;

import com.ecommerce.core.common.Price;
import com.ecommerce.core.order.payment.PaymentMode;

import java.util.Date;

public class CardDetail {
    private String cardType;
    private String cardNumber;
    private String cvv;
    private Date expiryDate;
}

