package com.ecommerce.customer.controller;

import com.ecommerce.core.product.Product;
import com.ecommerce.customer.dto.SearchCriteria;
import com.ecommerce.customer.service.ProductSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductSearchController {

    @Autowired
    private ProductSearchService productSearchService;

    @PostMapping("/products")
    public List<Product> searchProducts(@RequestBody SearchCriteria searchCriteria) {
        List<Product> productList = productSearchService.search(searchCriteria);
        return productList;
    }
}
