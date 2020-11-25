package com.ecommerce.payment.controller;

import com.ecommerce.core.common.Price;
import com.ecommerce.core.order.payment.PaymentMode;
import com.ecommerce.core.order.payment.PaymentRequest;
import com.ecommerce.payment.EcommercePaymentApplication;
import com.ecommerce.payment.service.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = EcommercePaymentApplication.class)
public class PaymentControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @MockBean
    private PaymentService paymentService;

    @Before
    public void setUp() throws Exception {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }

    @Test
    public void addToCartTest() throws Exception {
        when(paymentService.makePayment(any())).thenReturn("payreq001");
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post("/payment")
                        .characterEncoding("UTF-8")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(getPaymentRequestInJson());

        this.mockMvc.perform(builder)
                .andExpect(content().string(containsString("payreq001")))
                .andExpect(MockMvcResultMatchers.status()
                        .isOk());
    }

    private String getPaymentRequestInJson() throws JsonProcessingException {
        Map<String, String> paymentDetails = new HashMap<>();
        paymentDetails.put("upiId","1234567890@abc");
        PaymentRequest paymentRequest = PaymentRequest.builder()
                .billAmount(new Price(1000, "INR"))
                .id("payreq001")
                .paymentMode(PaymentMode.UPI)
                .paymentDetails(paymentDetails)
                .build();
        return new ObjectMapper().writeValueAsString(paymentRequest);
    }
}
