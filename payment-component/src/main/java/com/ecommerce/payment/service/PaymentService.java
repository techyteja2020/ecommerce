package com.ecommerce.payment.service;

import com.ecommerce.core.order.payment.PaymentRequest;
import com.ecommerce.payment.entity.PaymentRecord;
import com.ecommerce.payment.processor.PaymentProcessor;
import com.ecommerce.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentProcessor paymentProcessor;

    @Autowired
    private PaymentRepository paymentRepository;

    public String makePayment(PaymentRequest paymentRequest) {
        PaymentRecord paymentRecord = paymentProcessor.process(paymentRequest);
        PaymentRecord savedRecord = paymentRepository.save(paymentRecord.getId(), paymentRecord);
        return savedRecord.getGatewayResponse().getSignature();
    }
}
