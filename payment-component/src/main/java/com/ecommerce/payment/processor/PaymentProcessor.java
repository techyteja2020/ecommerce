package com.ecommerce.payment.processor;

import com.ecommerce.core.common.Price;
import com.ecommerce.core.order.payment.PaymentMode;
import com.ecommerce.core.order.payment.PaymentRequest;
import com.ecommerce.core.order.payment.PaymentStatus;
import com.ecommerce.payment.entity.PaymentRecord;
import com.ecommerce.payment.processor.gateway.GatewayProvider;
import com.ecommerce.payment.processor.gateway.GatewayResponse;
import com.ecommerce.payment.processor.gateway.PaymentGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentProcessor {

    @Autowired
    private GatewayProvider gatewayProvider;

    public PaymentRecord process(PaymentRequest paymentRequest) {
        PaymentMode paymentMode = paymentRequest.getPaymentMode();
        PaymentGateway paymentGateway = gatewayProvider.getGateway(paymentMode);
        Price billAmount = paymentRequest.getBillAmount();

        GatewayResponse gatewayResponse = paymentGateway.checkout(billAmount,
                paymentRequest.getPaymentDetails(),
                paymentRequest.getId());

        return new PaymentRecord(paymentRequest.getId(), paymentMode,
                PaymentStatus.Done,
                paymentRequest.getPaymentDetails(),
                billAmount,
                gatewayResponse);
    }


}
