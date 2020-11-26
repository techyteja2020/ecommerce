package com.ecommerce.core.seller;

import com.ecommerce.core.product.Category;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDefinition {
    private String name;
    private String brandName;
    private String modelNumber;
    private Map<String,String> specs;
    private String id;
    private Category category;
}
