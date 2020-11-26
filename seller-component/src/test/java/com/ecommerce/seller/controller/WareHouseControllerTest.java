package com.ecommerce.seller.controller;

import com.ecommerce.core.product.Category;
import com.ecommerce.core.seller.ProductDefinition;
import com.ecommerce.seller.SellerEcommerceApplication;
import com.ecommerce.seller.service.WareHouseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SellerEcommerceApplication.class)
@AutoConfigureMockMvc
class WareHouseControllerTest {
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WareHouseService wareHouseService;

    @Before
    public void converters() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        when(wareHouseService.fillStock(any(), any(),any())).thenReturn("stock001");
        String sellerId = "seller001";
        String productId = "pr001";

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/sellers/"+sellerId+"/products")
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(getProductDefinitionInJson(productId));

        this.mockMvc.perform(builder)
                .andExpect(content().string(containsString("pr001")));
    }

    private String getProductDefinitionInJson(String productId) throws JsonProcessingException {

        String name = "LG SMART TV";
        String brandName = "LG";
        String modelNumber = "LG1232";
        Map<String,String> specs = new HashMap<>();
        Category category = Category.Appliances;
        return new ObjectMapper().writeValueAsString(
                ProductDefinition.builder()
                        .brandName(brandName)
                        .category(category)
                        .id(productId)
                        .name(name)
                        .modelNumber(modelNumber)
                        .specs(specs)
                        .build()
        );
    }
}
