package com.ecommerce.customer.service;

import com.ecommerce.core.product.Product;
import com.ecommerce.customer.dto.Criteria;
import com.ecommerce.customer.dto.SearchCriteria;
import com.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductSearchService {

    @Autowired
    private ProductService productService;

    public List<Product> search(SearchCriteria searchCriteria) {
        List<Product> products = productService.getProducts();

        switch (searchCriteria.getBooleanSearchOperator()){

            case OR:
                products = filterOR(searchCriteria.getCriteriaList(),products);
                break;

            case AND:
                products = filterAnd(searchCriteria.getCriteriaList(),products);
                break;
        }

        return products;
    }

    private List<Product> filterAnd(List<Criteria> criteriaList, List<Product> products) {
        List<Product> filteredList = new ArrayList<>();

        return filteredList;
    }

    private List<Product> filterOR(List<Criteria> criteriaList, List<Product> products) {
        List<Product> filteredList = new ArrayList<>();

        return filteredList;
    }
}
