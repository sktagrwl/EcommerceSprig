package com.example.Ecommerce.services;

import com.example.Ecommerce.dto.AllProductsOfACategoryDTO;
import com.example.Ecommerce.dto.CategoryDTO;
import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.entity.Category;
import com.example.Ecommerce.entity.Product;
import com.example.Ecommerce.exception.CategoryNotFoundException;
import com.example.Ecommerce.mappers.CategoryMapper;
import com.example.Ecommerce.mappers.ProductMapper;
import com.example.Ecommerce.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public CategoryDTO getByName(String name) throws IOException {
        Category category = categoryRepository.findByName(name)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with name: " + name));

        return CategoryMapper.toDto(category);
    }

    @Override
    public AllProductsOfACategoryDTO getAllProductsOfACategory(Long id) throws IOException {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id " + id));

        List<ProductDTO> productDTOS = category.getProducts()
                .stream()
                .map(product -> ProductMapper.toDto(product))
                .collect(Collectors.toList());

        return AllProductsOfACategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .products(productDTOS)
                .build();

    }
}
