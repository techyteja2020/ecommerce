package com.ecommerce.payment.repository;

import com.ecommerce.core.CustomRepository;
import com.ecommerce.payment.entity.PaymentRecord;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository extends CustomRepository<PaymentRecord> {

    public PaymentRecord save(String orderId, PaymentRecord paymentRecord){
        return super.save(orderId,paymentRecord);
    }
}
