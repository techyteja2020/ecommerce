package com.ecommerce.payment.processor.gateway;

import com.ecommerce.core.common.Price;
import com.ecommerce.payment.model.NetbankingDetail;
import com.ecommerce.payment.model.ObjectMapperUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InternetBankingPaymentGateway implements PaymentGateway {

    @Override
    public GatewayResponse checkout(Price billAmount, Map<String, String> paymentDetails, String id) {
        NetbankingDetail netbankingDetail =
                new ObjectMapperUtil<NetbankingDetail>()
                        .convertMapTo(paymentDetails,
                                NetbankingDetail.class);
        //call third party api of gateway to checkout payment
        //provide billAmount, details required for payment and orderId
        //and get gateway response from them
        return new GatewayResponse(id, "signature001");
    }
}
