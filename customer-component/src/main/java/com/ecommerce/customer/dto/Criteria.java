package com.ecommerce.customer.dto;

public class Criteria {
    private String field;
    private SearchOperator operator;
    private String value;
    private String datatype;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public SearchOperator getOperator() {
        return operator;
    }

    public void setOperator(SearchOperator operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }
}
