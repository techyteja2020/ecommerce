package com.ecommerce.payment.processor.gateway;

import com.ecommerce.core.order.payment.PaymentMode;
import com.ecommerce.payment.EcommercePaymentApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = EcommercePaymentApplication.class)
public class GatewayProviderTest {
    @Autowired
    private GatewayProvider gatewayProvider;

    @Autowired
    private UPIPaymentGateway upiPaymentGateway;

    @Autowired
    private InternetBankingPaymentGateway internetBankingPaymentGateway;

    @Autowired
    private CardPaymentGateway cardPaymentGateway;

    @Test
    public void testGetProvider(){
        PaymentGateway gateway = gatewayProvider.getGateway(PaymentMode.UPI);
        assertEquals(gateway, upiPaymentGateway);
    }

    @Test
    public void testGetProvider1(){
        PaymentGateway gateway = gatewayProvider.getGateway(PaymentMode.NetBanking);
        assertEquals(gateway, internetBankingPaymentGateway);
    }

    @Test
    public void testGetProvider2(){
        PaymentGateway gateway = gatewayProvider.getGateway(PaymentMode.Card);
        assertEquals(gateway, cardPaymentGateway);
    }
}
