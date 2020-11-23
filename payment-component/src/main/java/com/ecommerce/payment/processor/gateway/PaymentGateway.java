package com.ecommerce.payment.processor.gateway;

import com.ecommerce.core.common.Price;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface PaymentGateway {
    GatewayResponse checkout(Price billAmount, Map<String, String> paymentDetails, String id);
}
