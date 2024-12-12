package com.eCommerce.eCommerce.exceptionHandler;

import com.eCommerce.eCommerce.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<String> handleCategoryNotFoundException(CategoryNotFoundException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductExistException.class)
    public ResponseEntity<String> handleProductExistException(ProductExistException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.FOUND);
    }

    @ExceptionHandler(CategoryExistException.class)
    public ResponseEntity<String> handleCategoryExistException(CategoryExistException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.FOUND);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerExistException.class)
    public ResponseEntity<String> handleCustomerExistException(CustomerExistException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleCartNotFoundException(CartNotFoundException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleCartItemHasThisProductException(CartItemHasThisProductException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleCartAlreadyExistOfCustomerException(CartAlreadyExistOfCustomerException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.FOUND);
    }
}
