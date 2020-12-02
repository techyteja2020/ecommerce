package com.ecommerce.customer.service;

import com.ecommerce.core.product.Product;
import com.ecommerce.customer.dto.Criteria;
import com.ecommerce.customer.dto.SearchCriteria;
import com.ecommerce.customer.filter.ProductCriteriaFilter;
import com.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductSearchService {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCriteriaFilter productCriteriaFilter;

    public List<Product> search(SearchCriteria searchCriteria) {
        List<Product> products = productService.getProducts();
        return applyCriteria(searchCriteria.getCriteriaList(),products);
    }

    private List<Product> applyCriteria(List<Criteria> criteriaList, List<Product> products) {
        return products.stream()
                .filter(product -> productCriteriaFilter.apply(product,criteriaList))
                .collect(Collectors.toList());
    }
}
