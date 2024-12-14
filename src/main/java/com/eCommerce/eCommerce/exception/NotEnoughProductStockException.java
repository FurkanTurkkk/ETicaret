package com.eCommerce.eCommerce.exception;

public class NotEnoughProductStockException extends RuntimeException {
    public NotEnoughProductStockException(String message) {
        super(message);
    }
}
