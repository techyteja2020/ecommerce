package com.ecommerce.seller.controller;

import com.ecommerce.core.seller.ProductDefinition;
import com.ecommerce.seller.service.ProductDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductDefinitionController {

    @Autowired
    private ProductDefinitionService productDefinitionService;

    @PostMapping("/sellers/{sellerId}/products")
    public ResponseEntity registerProduct(@RequestBody ProductDefinition product,
                                          @PathVariable("sellerId") String sellerId) {
        String productId = productDefinitionService.register(product, sellerId);
        return new ResponseEntity(productId, HttpStatus.CREATED);
    }

}
