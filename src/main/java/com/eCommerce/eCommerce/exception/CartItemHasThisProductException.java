package com.eCommerce.eCommerce.exception;

public class CartItemHasThisProductException extends RuntimeException {
    public CartItemHasThisProductException(String message) {
        super(message);
    }
}
