package com.ecommerce.customer.filter;

import com.ecommerce.customer.dto.Criteria;

import java.util.List;

public interface CriteriaFilter<T> {
    boolean apply(T entity, List<Criteria> criteriaList);
}
