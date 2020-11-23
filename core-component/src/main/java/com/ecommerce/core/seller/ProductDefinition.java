package com.ecommerce.core.seller;

import com.ecommerce.core.product.Category;
import com.ecommerce.core.product.Product;

import java.util.Map;

public class ProductDefinition {
    private String name;
    private String brandName;
    private String modelNumber;
    private Map<String,String> specs;
    private String id;
    private Category category;

    /*public ProductDefinition(String name, String brandName, String modelNumber, Map<String, String> specs, String id, Category category) {
        this.name = name;
        this.brandName = brandName;
        this.modelNumber = modelNumber;
        this.specs = specs;
        this.id = id;
        this.category = category;
    }*/

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }


    public Map<String, String> getSpecs() {
        return specs;
    }

    public void setSpecs(Map<String, String> specs) {
        this.specs = specs;
    }

    public Product convertToProduct(String sellerId){
        return new Product(
                this.name,
                this.brandName,
                this.modelNumber,
                this.specs,
                this.id,
                this.category,
                sellerId
        );
    }
}
