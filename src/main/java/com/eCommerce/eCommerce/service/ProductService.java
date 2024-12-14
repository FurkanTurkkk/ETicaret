package com.eCommerce.eCommerce.service;

import com.eCommerce.eCommerce.model.cart.Cart;
import com.eCommerce.eCommerce.model.cartItem.CartItem;
import com.eCommerce.eCommerce.utilityClasses.NormalizeString;
import com.eCommerce.eCommerce.dto.productDto.ProductDto;
import com.eCommerce.eCommerce.dtoConverter.productDtoConverter.ProductDtoConverter;
import com.eCommerce.eCommerce.exception.ProductExistException;
import com.eCommerce.eCommerce.exception.ProductNotFoundException;
import com.eCommerce.eCommerce.model.category.Category;
import com.eCommerce.eCommerce.model.product.Product;
import com.eCommerce.eCommerce.repository.ProductRepository;
import com.eCommerce.eCommerce.request.productRequest.RequestOfCreateForProduct;
import com.eCommerce.eCommerce.service.implementation.Helper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final Helper helper;
    private final ProductDtoConverter productDtoConverter;

    public ProductService(ProductRepository productRepository,
                          CategoryService categoryService,
                          Helper helper,
                          ProductDtoConverter productDtoConverter) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.helper = helper;
        this.productDtoConverter = productDtoConverter;
    }

    public Product findProductByIdOrThrow(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product can not found by id : " + id));
    }

    public Product findProductByNameAndColorOrThrow(String name, String color) {
        String registeredName = NormalizeString.normalizeString(name);
        String registeredColor = NormalizeString.normalizeString(color);
        return productRepository.findByNameAndColor(registeredName, registeredColor)
                .orElseThrow(() -> new ProductNotFoundException("Product can not found by name and color"));
    }


    public ProductDto findProductByNameAndColor(String name, String color) {
        Product product = findProductByNameAndColorOrThrow(name, color);
        return productDtoConverter.convert(product);
    }

    public Set<Product> findAllProduct() {
        return new HashSet<>(productRepository.findAll());
    }

    public ProductDto addProduct(RequestOfCreateForProduct request) {
        String productName = NormalizeString.normalizeString(request.name());
        String productColor = NormalizeString.normalizeString(request.color());
        String categoryName = NormalizeString.normalizeString(request.categoryName());
        Category category = categoryService.findByNameOrThrow(categoryName);
        Optional<Product> registeredProduct = productRepository.findByNameAndColor(productName,productColor);
        if (registeredProduct.isPresent()) {
            Product existProduct = registeredProduct.get();
            existProduct.increaseStock(request.stock());
            productRepository.save(existProduct);
            throw new ProductExistException("Product already exist upgraded stock : " + existProduct.getStock());

        }
        Product product = new Product(
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

    @Transactional
    public String deleteProductById(Long id) {
        Product product = findProductByIdOrThrow(id);
        product.getCartItems().forEach(cartItem -> {
            Cart cart = cartItem.getCart();
            cart.removeCartItem(cartItem);
        });
        product.getOrderItems().clear();
        productRepository.delete(product);
        return "Product deleted successfully by id " + product.getName();
    }

    public String deleteProductByNameAndColor(String name, String color) {
        Product product = findProductByNameAndColorOrThrow(name, color);
        productRepository.delete(product);
        return "Product deleted successfully by name " + name + " and color " + color;
    }
}
