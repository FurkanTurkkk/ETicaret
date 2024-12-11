package com.eCommerce.eCommerce.service;

import com.eCommerce.eCommerce.dto.productDto.ProductDto;
import com.eCommerce.eCommerce.dtoConverter.productDtoConverter.ProductDtoConverter;
import com.eCommerce.eCommerce.exception.ProductExistException;
import com.eCommerce.eCommerce.exception.ProductNotFoundException;
import com.eCommerce.eCommerce.model.category.Category;
import com.eCommerce.eCommerce.model.product.Product;
import com.eCommerce.eCommerce.repository.ProductRepository;
import com.eCommerce.eCommerce.request.productRequest.RequestOfCreateForProduct;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ProductDtoConverter productDtoConverter;

    public ProductService(ProductRepository productRepository,
                          CategoryService categoryService,
                          ProductDtoConverter productDtoConverter) {

        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.productDtoConverter = productDtoConverter;
    }

    public Product findProductByIdOrThrow(Long id){
        return productRepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException("Product can not found by id : "+id));
    }

    public Product findProductByNameOrThrow(String name){
        String registeredName=name.toLowerCase().trim();
        return productRepository.findByName(registeredName)
                .orElseThrow(()->new ProductNotFoundException("Product can not found by name : "+name));
    }

    public ProductDto findProductByName(String name){
        Product product=findProductByNameOrThrow(name);
        return productDtoConverter.convert(product);
    }

    public ProductDto addProduct(RequestOfCreateForProduct request){
        String productName=Product.normalizeName(request.getName());
        if(productRepository.findByName(productName).isPresent()){
            Product product= findProductByNameOrThrow(productName);
            product.increaseStock(request.getStock());
            productRepository.save(product);
            throw new ProductExistException("Product already exist upgrade "+productName+" stock");
        }
        Category category=categoryService.findByIdOrThrow(request.getCategoryId());
        Product product=new Product(productName,
                category,
                request.getPrice(),
                request.getStock(),
                request.getColor());
        category.getProducts().add(product);
        return productDtoConverter.convert(productRepository.save(product));
    }

    public String deleteProductById(Long id){
        Product product= findProductByIdOrThrow(id);
        productRepository.delete(product);
        return "Product deleted successfully by id "+product.getName();
    }

    public String deleteProductByName(String name){
        Product product= findProductByNameOrThrow(name);
        productRepository.delete(product);
        return "Product deleted successfully by name "+name;
    }
}
