package com.ecommerce.seller.controller;

import com.ecommerce.core.common.Price;
import com.ecommerce.core.seller.ProductStockDescriptor;
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

import java.util.ArrayList;
import java.util.List;

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
    public void shouldSuccessfullyFillStockForGivenProduct() throws Exception {
        when(wareHouseService.fillStock(any(), any(), any())).thenReturn("stock001");
        String sellerId = "seller001";
        String productId = "pr001";

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/sellers/" + sellerId + "/products/" + productId+"/stocks")
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(getProductDefinitionInJson(productId));

        this.mockMvc.perform(builder)
                .andExpect(content().string(containsString("pr001")));
    }

    private String getProductDefinitionInJson(String productId) throws JsonProcessingException {

        List<String> barcodeList = new ArrayList();
        String barcode1 = "tv123001";
        String barcode2 = "tv123002";
        barcodeList.add(barcode1);
        barcodeList.add(barcode2);
        Price price = new Price(24000.00, "INR");
        String stockId = "stockId";

        return new ObjectMapper().writeValueAsString(
                ProductStockDescriptor.builder()
                        .id(stockId)
                        .quantity(4)
                        .barcodeList(barcodeList)
                        .price(price).build()
        );
    }
}
