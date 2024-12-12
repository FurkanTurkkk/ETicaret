package com.eCommerce.eCommerce.exception;

public class CartAlreadyExistOfCustomerException extends RuntimeException {
    public CartAlreadyExistOfCustomerException(String message) {
        super(message);
    }
}
