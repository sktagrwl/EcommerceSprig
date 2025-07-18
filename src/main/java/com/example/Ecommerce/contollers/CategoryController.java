package com.example.Ecommerce.contollers;

import com.example.Ecommerce.dto.CategoryDTO;
import com.example.Ecommerce.services.ICategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;
@RestController
@RequestMapping("/api/categories")
public class  CategoryController {

    private final ICategoryService categoryService;

    //Constructor based Dependency Injection
    public CategoryController(
            @Qualifier("CategoryService") ICategoryService _categoryService) {

        this.categoryService = _categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() throws IOException {
        List<CategoryDTO> result = this.categoryService.getAllCategories();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) throws IOException {
        CategoryDTO result = this.categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok(result);
    }


}


// new CategoryController(new fakeStoreCategoryService());