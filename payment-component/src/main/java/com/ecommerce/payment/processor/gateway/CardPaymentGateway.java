package com.ecommerce.payment.processor.gateway;

import com.ecommerce.core.common.Price;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("cardPaymentGateway")
public class CardPaymentGateway implements PaymentGateway {
    @Override
    public GatewayResponse checkout(Price billAmount, Map<String, String> paymentDetails, String id) {

        return null;
    }
}
