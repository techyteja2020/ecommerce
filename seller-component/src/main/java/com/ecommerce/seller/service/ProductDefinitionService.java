package com.ecommerce.seller.service;


import com.ecommerce.core.product.Product;
import com.ecommerce.core.seller.ProductDefinition;
import com.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDefinitionService {

    @Autowired
    private ProductService productService;

    public String register(ProductDefinition productDefinition, String sellerId) {
        Product product = this.convertToProduct(sellerId, productDefinition);
        productService.createProduct(product);
        return product.getId();
    }

    private Product convertToProduct(String sellerId, ProductDefinition productDefinition) {
        return Product.builder()
                .brandName(productDefinition.getBrandName())
                .category(productDefinition.getCategory())
                .createdBy(sellerId)
                .id(productDefinition.getId())
                .modelNumber(productDefinition.getModelNumber())
                .name(productDefinition.getName())
                .specs(productDefinition.getSpecs())
                .build();
    }


}
