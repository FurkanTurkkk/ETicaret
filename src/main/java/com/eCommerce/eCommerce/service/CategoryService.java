package com.eCommerce.eCommerce.service;

import com.eCommerce.eCommerce.dto.categoryDto.CategoryDto;
import com.eCommerce.eCommerce.dto.categoryDto.WithProductsCategoryDto;
import com.eCommerce.eCommerce.dtoConverter.categoryDtoConverter.CategoryDtoConverter;
import com.eCommerce.eCommerce.dtoConverter.categoryDtoConverter.WithProductsCategoryConverter;
import com.eCommerce.eCommerce.exception.CategoryExistException;
import com.eCommerce.eCommerce.exception.CategoryNotFoundException;
import com.eCommerce.eCommerce.model.category.Category;
import com.eCommerce.eCommerce.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryDtoConverter categoryDtoConverter;
    private final WithProductsCategoryConverter withProductsCategoryConverter;

    public CategoryService(CategoryRepository categoryRepository,
                           CategoryDtoConverter converter,
                           WithProductsCategoryConverter withProductsCategoryConverter) {
        this.categoryRepository = categoryRepository;
        this.categoryDtoConverter = converter;
        this.withProductsCategoryConverter = withProductsCategoryConverter;
    }

    public CategoryDto createNewCategoryOnDb(Category category){
        if(categoryRepository.findByName(category.getName()).isPresent()){
            throw new CategoryExistException("Category already Exist");
        }
        Category registeredCategory=categoryRepository.save(category);
        return categoryDtoConverter.convert(registeredCategory);
    }

    public Category findByNameOrThrow(String name){
        return categoryRepository.findByName(name)
                .orElseThrow(()->new CategoryNotFoundException("Category is not found by name "+" "+name));
    }

    public Category findByIdOrThrow(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(()->new CategoryNotFoundException("Category is not found by id "+" "+id));
    }

    public WithProductsCategoryDto getCategoryById(Long id){
        Category category= findByIdOrThrow(id);
        return withProductsCategoryConverter.convert(category);
    }


    public WithProductsCategoryDto getCategoryByName(String name){
        Category category= findByNameOrThrow(name);
        return withProductsCategoryConverter.convert(category);
    }


    public String deleteCategoryById(Long id){
        Category category=findByIdOrThrow(id);
        categoryRepository.delete(category);
        return "Category deleted successfully by id "+category.getName();
    }

    public String deleteCategoryByName(String name){
        Category category=findByNameOrThrow(name);
        categoryRepository.delete(category);
        return "Category deleted successfully by name "+name;
    }

}
