package com.eCommerce.eCommerce.controller;

import com.eCommerce.eCommerce.dto.categoryDto.CategoryDto;
import com.eCommerce.eCommerce.dto.categoryDto.WithProductsCategoryDto;
import com.eCommerce.eCommerce.model.category.Category;
import com.eCommerce.eCommerce.request.categoryRequest.RequestOfCreateForCategory;
import com.eCommerce.eCommerce.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createNewCategory(@RequestBody RequestOfCreateForCategory request){
        Category category=new Category(request.getName());
        CategoryDto categoryDto=categoryService.createNewCategoryOnDb(category);
        return ResponseEntity.ok(categoryDto);
    }

    @GetMapping("/id/{category_id}")
    public ResponseEntity<WithProductsCategoryDto> getCategoryById(@PathVariable("category_id") Long id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @GetMapping("/name/{category_name}")
    public ResponseEntity<WithProductsCategoryDto> getCategoryByName(@PathVariable("category_name") String name){
        return ResponseEntity.ok(categoryService.getCategoryByName(name));
    }


}
