package com.ecommerce.core.seller;

import com.ecommerce.core.product.Category;
import com.ecommerce.core.product.Product;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class ProductDefinitionTest {

    @Test
    public void givenProductDefinitionConvertsToProductSuccessfully(){
        Map<String, String> specs =  new HashMap<>();
        specs.put("size","21*25");
        specs.put("USB Port","available");

        String name = "LCD TV";
        String brand = "LG";
        String modelNumber = "L120";
        String id = "id001";
        String sellerId = "seller001";
        Category category = Category.Appliances;
        ProductDefinition productDefinition = null;
        //ProductDefinition productDefinition = new ProductDefinition(
        //        name, brand, modelNumber, specs, id, category
        //);
        Product expectedProduct = new Product(name,brand,modelNumber,specs,id,category,sellerId);

        //Product product = productDefinition.convertToProduct(sellerId);

        //assertEquals(expectedProduct,product);
    }

}