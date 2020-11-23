package com.ecommerce.core.exception;

public class ProductAlreadyExistsException extends RuntimeException {
    private static String message = "Product already exists with id: ";

    public ProductAlreadyExistsException(String productId) {
        super(message+productId);
    }
}
