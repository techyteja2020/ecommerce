package com.ecommerce.customer.controller;


import com.ecommerce.cart.service.CartService;
import com.ecommerce.core.common.Price;
import com.ecommerce.core.customer.CartItem;
import com.ecommerce.core.order.CustomerOrder;
import com.ecommerce.customer.CustomerEcommerceApplication;
import com.ecommerce.order.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerEcommerceApplication.class)
@AutoConfigureMockMvc
public class OrderControllerTest {
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Before
    public void converters() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        when(orderService.createOrder(any(), any())).thenReturn("order001");
        String customerId = "cu001";
        String cartId = "cucart001";
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/customers/"+customerId+"/order")
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(getCustomerOrderInJson());
        this.mockMvc.perform(builder)
                .andExpect(content().string(containsString("order001")));
    }

    private String getCustomerOrderInJson() throws JsonProcessingException {

        String id = "order001";
        String paymentTxnid = "tx001";
        String cartId = "cart001";
        String billToAddressId = "Home Address ";
        String shipToAddressId = "Office Address";
        String paymentRecordId = "payment001";
        return new ObjectMapper().writeValueAsString(new CustomerOrder(id,paymentTxnid,cartId,billToAddressId, shipToAddressId, paymentRecordId));
    }
}
