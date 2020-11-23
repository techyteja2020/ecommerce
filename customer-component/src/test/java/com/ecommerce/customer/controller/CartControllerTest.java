package com.ecommerce.customer.controller;

import com.ecommerce.cart.service.CartService;
import com.ecommerce.core.common.Price;
import com.ecommerce.core.customer.CartItem;
import com.ecommerce.customer.CustomerEcommerceApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.Charset;
import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerEcommerceApplication.class)
@AutoConfigureMockMvc
public class CartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartService cartService;

    @Bean
    public HttpMessageConverters converters() {
        return new HttpMessageConverters(
                true, Arrays.asList(new MappingJackson2HttpMessageConverter()));
    }

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        when(cartService.addProduct(any(), any(),any())).thenReturn("id001");
        String customerId = "cu001";
        String cartId = "cucart001";
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/customers/"+customerId+"/carts/"+cartId+"/add")
                //.header("Content-Type",MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(getRetailProductInJson());
        this.mockMvc.perform(builder)
                .andExpect(content().string(containsString("id001")));
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