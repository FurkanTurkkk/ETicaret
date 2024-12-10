package com.eCommerce.eCommerce.dtoConverter.categoryDtoConverter;

import com.eCommerce.eCommerce.dto.categoryDto.CategoryDto;
import com.eCommerce.eCommerce.model.category.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoConverter {

    public CategoryDto convert(Category category){
        return new CategoryDto(category.getName());
    }
}
