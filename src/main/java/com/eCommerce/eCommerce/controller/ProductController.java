package com.eCommerce.eCommerce.controller;

import com.eCommerce.eCommerce.dto.productDto.ProductDto;
import com.eCommerce.eCommerce.dtoConverter.productDtoConverter.ProductDtoConverter;
import com.eCommerce.eCommerce.request.productRequest.RequestOfCreateForProduct;
import com.eCommerce.eCommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService, ProductDtoConverter converter, CategoryController categoryController) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDto> addNewProduct(@RequestBody RequestOfCreateForProduct request){
        return ResponseEntity.ok(productService.addProduct(request));
    }

    @GetMapping("/find/name/{productName}")
    public ResponseEntity<ProductDto> findProductByName(@PathVariable("productName") String name){
        return ResponseEntity.ok(productService.findProductByName(name));
    }

    @DeleteMapping("/delete/id/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable("productId") Long id){
        return ResponseEntity.ok(productService.deleteProductById(id));
    }

    @DeleteMapping("/delete/name/{productName}")
    private ResponseEntity<String> deleteProductByName(@PathVariable("productName") String name){
        return ResponseEntity.ok(productService.deleteProductByName(name));
    }
}
