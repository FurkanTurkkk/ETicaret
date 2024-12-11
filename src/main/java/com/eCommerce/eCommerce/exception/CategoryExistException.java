package com.eCommerce.eCommerce.exception;

public class CategoryExistException extends RuntimeException {
  public CategoryExistException(String message) {
    super(message);
  }
}
