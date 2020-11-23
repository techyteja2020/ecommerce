package com.ecommerce.payment.controller;

import com.ecommerce.core.order.payment.PaymentRequest;
import com.ecommerce.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    public String makePayment(@RequestBody PaymentRequest paymentRequest){
        String customerId = "";
        return paymentService.makePayment(paymentRequest, customerId);
    }

}
