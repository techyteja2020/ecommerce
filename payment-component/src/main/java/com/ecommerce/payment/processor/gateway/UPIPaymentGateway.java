package com.ecommerce.payment.processor.gateway;

import com.ecommerce.core.common.Price;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class UPIPaymentGateway implements PaymentGateway {
    @Override
    public GatewayResponse checkout(Price billAmount, Map<String, String> paymentDetails, String id) {
        //Mock call to UPI payment gateway
        UUID paymentSignature = UUID.randomUUID();
        System.out.println(paymentSignature.toString());
        GatewayResponse response = new GatewayResponse(id,paymentSignature.toString());
        return response;
    }
}
