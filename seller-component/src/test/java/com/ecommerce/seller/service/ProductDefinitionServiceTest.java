package com.ecommerce.seller.service;

import com.ecommerce.core.product.Product;
import com.ecommerce.core.seller.ProductDefinition;
import com.ecommerce.product.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductDefinitionServiceTest {
    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductDefinitionService productDefinitionService;

    @Test
    public void testRegisterProduct() {
        ProductDefinition productDefinition =
                ProductDefinition.builder()
                        .id("pro001")
                        .build();
        when(productService.createProduct(any()))
                .thenReturn(Product.builder()
                        .id("pro001")
                        .build());

        String productId = productDefinitionService.register(productDefinition, "");

        assertEquals("pro001", productId);
    }
}
