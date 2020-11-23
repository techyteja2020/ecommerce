package com.ecommerce.product.service;

import com.ecommerce.core.product.Product;
import com.ecommerce.core.exception.ProductAlreadyExistsException;
import com.ecommerce.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        if(getProductId(product.getId()) != null){
            throw new ProductAlreadyExistsException(product.getId());
        }
        return productRepository.save(product);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProductId(String productId) {
        return productRepository.getById(productId);
    }

    public List<Product> getProducts() {
        return productRepository.getAll();
    }

}