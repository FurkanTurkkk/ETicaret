package com.eCommerce.eCommerce.controller;

import com.eCommerce.eCommerce.dto.productDto.ProductDto;
import com.eCommerce.eCommerce.dtoConverter.productDtoConverter.ProductDtoConverter;
import com.eCommerce.eCommerce.request.productRequest.RequestOfCreateForProduct;
import com.eCommerce.eCommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
