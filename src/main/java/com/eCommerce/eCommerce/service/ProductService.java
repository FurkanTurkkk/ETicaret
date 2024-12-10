package com.eCommerce.eCommerce.service;

import com.eCommerce.eCommerce.dto.productDto.ProductDto;
import com.eCommerce.eCommerce.dtoConverter.productDtoConverter.ProductDtoConverter;
import com.eCommerce.eCommerce.model.category.Category;
import com.eCommerce.eCommerce.model.product.Product;
import com.eCommerce.eCommerce.repository.ProductRepository;
import com.eCommerce.eCommerce.request.RequestOfCreateForProduct;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ProductDtoConverter productDtoConverter;

    public ProductService(ProductRepository productRepository, CategoryService categoryService, ProductDtoConverter productDtoConverter) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.productDtoConverter = productDtoConverter;
    }

    public ProductDto addProduct(RequestOfCreateForProduct request){
        Category category=categoryService.findByIdOrThrow(request.getCategoryId());
        Product product=new Product(request.getName(),
                category,
                request.getPrice(),
                request.getStock(),
                request.getColor());
        return productDtoConverter.convert(productRepository.save(product));
    }

}
