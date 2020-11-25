package com.ecommerce.payment.processor;

import com.ecommerce.core.common.Price;
import com.ecommerce.core.order.payment.PaymentMode;
import com.ecommerce.core.order.payment.PaymentRequest;
import com.ecommerce.core.order.payment.PaymentStatus;
import com.ecommerce.payment.entity.PaymentRecord;
import com.ecommerce.payment.processor.gateway.GatewayProvider;
import com.ecommerce.payment.processor.gateway.GatewayResponse;
import com.ecommerce.payment.processor.gateway.UPIPaymentGateway;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PaymentProcessorTest {

    @Mock
    private GatewayProvider gatewayProvider;

    @InjectMocks
    private PaymentProcessor paymentProcessor;

    @Mock
    private UPIPaymentGateway upiPaymentGateway;

    @Test
    public void testProcess(){
        PaymentRequest paymentRequest = getPaymentRequest();
        GatewayResponse gatewayResponse = new GatewayResponse("paymentId001","sign001");
        when(gatewayProvider.getGateway(any())).thenReturn(upiPaymentGateway);
        when(upiPaymentGateway.checkout(any(),any(),any())).thenReturn(gatewayResponse);

        PaymentRecord paymentRecord = paymentProcessor.process(paymentRequest);

        assertEquals(paymentRecord.getGatewayResponse(),gatewayResponse);
        assertEquals(paymentRecord.getId(),paymentRequest.getId());
        assertEquals(paymentRecord.getPaymentStatus(), PaymentStatus.Done);
        assertEquals(paymentRecord.getAmountForPayment(),paymentRequest.getBillAmount());
        assertEquals(paymentRecord.getPaymentMode(),paymentRequest.getPaymentMode());
        assertEquals(paymentRecord.getPaymentDetails(),paymentRequest.getPaymentDetails());
    }

    private PaymentRequest getPaymentRequest(){
        Map<String, String> paymentDetails = new HashMap<>();
        paymentDetails.put("upiId","1234567890@abc");
        return PaymentRequest.builder()
                .billAmount(new Price(1000, "INR"))
                .id("payreq001")
                .paymentMode(PaymentMode.UPI)
                .paymentDetails(paymentDetails)
                .build();
    }
}
