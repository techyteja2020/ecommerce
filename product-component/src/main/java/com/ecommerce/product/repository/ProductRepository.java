package com.ecommerce.product.repository;

import com.ecommerce.core.CustomRepository;
import com.ecommerce.core.product.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository extends CustomRepository<Product> {

    public Product save(Product product) {
        return super.save(product.getId(), product);
    }

    public Product getById(String productId) {
        return super.findOne(productId);
    }


    public List<Product> getAll() {
        return super.findAll();
    }

    @PostConstruct
    void init() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        String products = IOUtils.toString(this.getClass().getResourceAsStream("/products.json"), StandardCharsets.UTF_8);
        List<Product> productList = objectMapper.readValue(products, new TypeReference<List<Product>>(){});
        productList.stream().collect(Collectors.toMap(Product::getId, product -> product));
    }
}


