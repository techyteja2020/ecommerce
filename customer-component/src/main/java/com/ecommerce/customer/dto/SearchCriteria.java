package com.ecommerce.customer.dto;

import java.util.List;

public class SearchCriteria {
    private BooleanSearchOperator booleanSearchOperator;
    private List<Criteria> criteriaList;

    public BooleanSearchOperator getBooleanSearchOperator() {
        return booleanSearchOperator;
    }

    public void setBooleanSearchOperator(BooleanSearchOperator booleanSearchOperator) {
        this.booleanSearchOperator = booleanSearchOperator;
    }

    public List<Criteria> getCriteriaList() {
        return criteriaList;
    }

    public void setCriteriaList(List<Criteria> criteriaList) {
        this.criteriaList = criteriaList;
    }
}
