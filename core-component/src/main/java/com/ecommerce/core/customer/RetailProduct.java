package com.ecommerce.core.customer;

import com.ecommerce.core.common.Price;
import com.ecommerce.core.product.Category;

import java.util.Map;

public class RetailProduct {
    private String name;
    private String brandName;
    private String modelNumber;
    private Map<String, String> specs;
    private String productId;
    private Category category;
    private Price price;
}
