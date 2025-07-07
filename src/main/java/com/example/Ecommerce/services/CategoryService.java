package com.example.Ecommerce.services;

import com.example.Ecommerce.dto.CategoryDTO;
import com.example.Ecommerce.entity.Category;
import com.example.Ecommerce.mappers.CategoryMapper;
import com.example.Ecommerce.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service("CategoryService")
public class CategoryService implements ICategoryService{


    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {

        List<CategoryDTO> dtos = new ArrayList<>();

        for(Category category : categoryRepository.findAll()){
            dtos.add(CategoryMapper.toDto(category));
        }
        return dtos;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) throws IOException {
        Category saved = categoryRepository.save(CategoryMapper.toEntity(categoryDTO));

        return CategoryMapper.toDto(saved);

    }
}
