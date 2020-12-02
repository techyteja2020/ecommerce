package com.ecommerce.customer.filter;

import com.ecommerce.core.product.Product;
import com.ecommerce.customer.dto.Criteria;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductCriteriaFilter implements CriteriaFilter<Product>{

    @Override
    public boolean apply(Product product, List<Criteria> list) {
        for (Criteria criteria : list) {
            if(!matches(product,criteria)){
                return false;
            }
        }
        return true;
    }

    boolean matches(Product product,Criteria criteria){

        switch (ProductFilter.valueOf(criteria.getField())){
            case BRAND_NAME:
                return product.getBrandName().equals(criteria.getValue());
            case COLOUR:
                return product.getSpecs().get(ProductFilter.COLOUR.name().toLowerCase()).equals(criteria.getValue());
            default:
                break;
        }
        return true;
    }

}
