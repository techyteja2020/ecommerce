package com.ecommerce.payment.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class ObjectMapperUtil<T> {

    @Autowired
    private ObjectMapper objectMapper;

    public T convertMapTo(Map<String, String> details, Class<T> t) {
        T detailsObject = null;
        try {
            detailsObject = objectMapper.readValue(objectMapper.writeValueAsString(details), t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return detailsObject;
    }
}
