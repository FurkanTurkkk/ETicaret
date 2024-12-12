package com.eCommerce.eCommerce.controller;

import com.eCommerce.eCommerce.dto.productDto.ProductDto;
import com.eCommerce.eCommerce.request.productRequest.RequestOfCreateForProduct;
import com.eCommerce.eCommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDto> addNewProduct(@RequestBody RequestOfCreateForProduct request){
        return ResponseEntity.ok(productService.addProduct(request));
    }

    @GetMapping("/find/name-color/{productName}/{productColor}")
    public ResponseEntity<ProductDto> findProductByName(@PathVariable("productName") String name,
                                                        @PathVariable("productColor") String color){
        return ResponseEntity.ok(productService.findProductByNameAndColor(name,color));
    }

    @DeleteMapping("/delete/id/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable("productId") Long id){
        return ResponseEntity.ok(productService.deleteProductById(id));
    }

    @DeleteMapping("/delete/name-color/{productName}/{productColor}")
    private ResponseEntity<String> deleteProductByNameAndColor(@PathVariable("productName") String name,
                                                               @PathVariable("productColor") String color){
        return ResponseEntity.ok(productService.deleteProductByNameAndColor(name,color));
    }
}
