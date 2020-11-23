package com.ecommerce.payment.processor.gateway;

import com.ecommerce.core.order.payment.PaymentMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class GatewayProvider {
    @Autowired
    private InternetBankingPaymentGateway internetBankingPaymentGateway;

    @Autowired
    private UPIPaymentGateway upiPaymentGateway;

    @Autowired
    private CardPaymentGateway cardPaymentGateway;

    private Map<PaymentMode,PaymentGateway> GATEWAY_MAP = new HashMap<>();


    @PostConstruct
    void init(){
        GATEWAY_MAP.put(PaymentMode.Card,cardPaymentGateway);
        GATEWAY_MAP.put(PaymentMode.UPI,upiPaymentGateway);
        GATEWAY_MAP.put(PaymentMode.NetBanking,internetBankingPaymentGateway);
    }


    public PaymentGateway getGateway(PaymentMode paymentMode){
        if(GATEWAY_MAP.size() ==0){
            throw new RuntimeException("");
        }
        return GATEWAY_MAP.get(paymentMode);
    }


}
