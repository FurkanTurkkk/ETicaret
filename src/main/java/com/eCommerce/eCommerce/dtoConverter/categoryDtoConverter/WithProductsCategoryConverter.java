package com.eCommerce.eCommerce.dtoConverter.categoryDtoConverter;

import com.eCommerce.eCommerce.dto.categoryDto.WithProductsCategoryDto;
import com.eCommerce.eCommerce.dtoConverter.productDtoConverter.ProductDtoConverter;
import com.eCommerce.eCommerce.model.category.Category;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class WithProductsCategoryConverter {

    private final ProductDtoConverter converter;

    public WithProductsCategoryConverter(ProductDtoConverter converter) {
        this.converter = converter;
    }

    public WithProductsCategoryDto convert(Category category){
        return new WithProductsCategoryDto(
                category.getName(),
                category.getProducts().stream()
                        .map(converter::convert)
                        .collect(Collectors.toSet())
        );
    }
}
