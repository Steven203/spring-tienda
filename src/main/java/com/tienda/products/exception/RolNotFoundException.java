package com.tienda.products.exception;

public class RolNotFoundException extends RuntimeException {

    public RolNotFoundException(String message) {
        super(message);
    }
}