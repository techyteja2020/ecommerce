package com.ecommerce.core.product;

import java.util.Map;
import java.util.Objects;

public class Product {
    private String name;
    private String brandName;
    private String modelNumber;
    private Map<String,String> specs;
    private String id;
    private Category category;
    private String createdBy;

    public String getId() {
        return id;
    }

    public Product(String name, String brandName, String modelNumber, Map<String, String> specs, String id, Category category, String createdBy) {
        this.name = name;
        this.brandName = brandName;
        this.modelNumber = modelNumber;
        this.specs = specs;
        this.id = id;
        this.category = category;
        this.createdBy = createdBy;
    }

    public Product() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name) &&
                brandName.equals(product.brandName) &&
                modelNumber.equals(product.modelNumber) &&
                specs.equals(product.specs) &&
                category == product.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, brandName, modelNumber, specs, category);
    }

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

    public void setId(String id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
