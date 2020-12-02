package com.ecommerce.payment.service;

import com.ecommerce.core.common.Price;
import com.ecommerce.core.order.payment.PaymentMode;
import com.ecommerce.core.order.payment.PaymentRequest;
import com.ecommerce.core.order.payment.PaymentStatus;
import com.ecommerce.payment.entity.PaymentRecord;
import com.ecommerce.payment.processor.PaymentProcessor;
import com.ecommerce.payment.processor.gateway.GatewayResponse;
import com.ecommerce.payment.repository.PaymentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {

    @Mock
    private PaymentProcessor paymentProcessor;

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentService paymentService;

    @Test
    public void shouldMakePaymentAndReturnPaymentSignature(){
        PaymentRequest paymentRequest = getPaymentRequestWithId("payreq001");
        PaymentRecord paymentRecord = buildPaymentRecordFrom(paymentRequest);
        when(paymentProcessor.process(paymentRequest)).thenReturn(paymentRecord);
        when(paymentRepository.save(paymentRecord.getId(),paymentRecord)).thenReturn(paymentRecord);

        String signature = paymentService.makePayment(paymentRequest);

        assertEquals("sign001",signature);
    }

    private PaymentRecord buildPaymentRecordFrom(PaymentRequest paymentRequest) {
        return new PaymentRecord(
                paymentRequest.getId(),
                paymentRequest.getPaymentMode(),
                PaymentStatus.Done,
                paymentRequest.getPaymentDetails(),
                paymentRequest.getBillAmount(),
                new GatewayResponse("paymentId001","sign001")
        );
    }

    private PaymentRequest getPaymentRequestWithId(String id){
        Map<String, String> paymentDetails = new HashMap<>();
        paymentDetails.put("upiId","1234567890@abc");
        return PaymentRequest.builder()
                .billAmount(new Price(1000, "INR"))
                .id(id)
                .paymentMode(PaymentMode.UPI)
                .paymentDetails(paymentDetails)
                .build();
    }
}
