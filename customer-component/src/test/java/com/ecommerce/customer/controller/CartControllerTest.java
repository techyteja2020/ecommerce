package com.ecommerce.customer.controller;

import com.ecommerce.cart.service.CartService;
import com.ecommerce.core.common.Price;
import com.ecommerce.core.customer.CartItem;
import com.ecommerce.customer.CustomerEcommerceApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = CustomerEcommerceApplication.class)
public class CartControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }

    @Test
    public void addToCartTest() throws Exception {
        String customerId = "cu001";
        String cartId = "cucart001";

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.put("/customers/"+customerId+"/carts/"+cartId+"/add")
                        .characterEncoding("UTF-8")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(getRetailProductInJson());

        this.mockMvc.perform(builder)
                .andExpect(content().string(containsString("cucart001")));
                /*.andExpect(MockMvcResultMatchers.status()
                        .isOk());*/
    }

    private String getRetailProductInJson() throws JsonProcessingException {

        String cartId = "cart001";
        String id = "id001";

        String productId = "pr001";
        double priceValue = 10000.0;
        String currency = "INR";
        return new ObjectMapper().writeValueAsString(new CartItem(id, cartId, productId, new Price(priceValue, currency)));
    }
}