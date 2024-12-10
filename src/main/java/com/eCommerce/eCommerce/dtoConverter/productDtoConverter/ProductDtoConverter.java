package com.eCommerce.eCommerce.dtoConverter.productDtoConverter;

import com.eCommerce.eCommerce.dto.productDto.ProductDto;
import com.eCommerce.eCommerce.dtoConverter.categoryDtoConverter.CategoryDtoConverter;
import com.eCommerce.eCommerce.model.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoConverter {

    private final CategoryDtoConverter converter;

    public ProductDtoConverter(CategoryDtoConverter converter) {
        this.converter = converter;
    }

    public ProductDto convert(Product product){
        return new ProductDto(
                product.getName(),
                product.getPrice(),
                product.getStock(),
                converter.convert(product.getCategory())
        );
    }

}
