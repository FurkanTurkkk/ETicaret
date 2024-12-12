package com.eCommerce.eCommerce.service;

import com.eCommerce.eCommerce.generalClass.NormalizeString;
import com.eCommerce.eCommerce.dto.productDto.ProductDto;
import com.eCommerce.eCommerce.dtoConverter.productDtoConverter.ProductDtoConverter;
import com.eCommerce.eCommerce.exception.ProductExistException;
import com.eCommerce.eCommerce.exception.ProductNotFoundException;
import com.eCommerce.eCommerce.model.category.Category;
import com.eCommerce.eCommerce.model.product.Product;
import com.eCommerce.eCommerce.repository.ProductRepository;
import com.eCommerce.eCommerce.request.productRequest.RequestOfCreateForProduct;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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

    public Product findProductByNameAndColorOrThrow(String name,String color){
        String registeredName= NormalizeString.normalizeString(name);
        String registeredColor=NormalizeString.normalizeString(color);
        return productRepository.findByNameAndColor(registeredName,registeredColor)
                .orElseThrow(()->new ProductNotFoundException("Product can not found by name and color"));
    }


    public ProductDto findProductByNameAndColor(String name,String color){
        Product product=findProductByNameAndColorOrThrow(name,color);
        return productDtoConverter.convert(product);
    }

    public Set<Product> findAllProduct(){
        return new HashSet<>(productRepository.findAll());
    }

    public ProductDto addProduct(RequestOfCreateForProduct request){
        String productName=NormalizeString.normalizeString(request.name());
        String productColor=NormalizeString.normalizeString(request.color());
        String categoryName=NormalizeString.normalizeString(request.categoryName());
        Category category=categoryService.findByNameOrThrow(categoryName);
        Set<Product> products= new HashSet<>(productRepository.findAll());
        Optional<Product> registeredProduct=productRepository.findByNameAndColor(request.name(),request.color());
        if (registeredProduct.isPresent()){
            Product existProduct=registeredProduct.get();
            if(products.contains(existProduct)){
                existProduct.increaseStock(request.stock());
                productRepository.save(existProduct);
                throw new ProductExistException("Product already exist upgraded stock : "+existProduct.getStock());
            }
        }
        Product product=new Product(
                productName,
                category,
                request.price(),
                request.stock(),
                productColor
        );
        productRepository.save(product);
        category.getProducts().add(product);
        return productDtoConverter.convert(product);
    }

    public String deleteProductById(Long id){
        Product product= findProductByIdOrThrow(id);
        productRepository.delete(product);
        return "Product deleted successfully by id "+product.getName();
    }

    public String deleteProductByNameAndColor(String name,String color){
        Product product= findProductByNameAndColorOrThrow(name,color);
        productRepository.delete(product);
        return "Product deleted successfully by name "+name+" and color "+color;
    }
}
