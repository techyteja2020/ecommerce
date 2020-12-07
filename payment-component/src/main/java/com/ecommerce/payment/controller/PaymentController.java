package com.ecommerce.payment.controller;

import com.ecommerce.core.order.payment.PaymentRequest;
import com.ecommerce.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity makePayment(@RequestBody PaymentRequest paymentRequest){
        String paymentSignature = paymentService.makePayment(paymentRequest);
        return new ResponseEntity(paymentSignature, HttpStatus.CREATED);
    }

}
