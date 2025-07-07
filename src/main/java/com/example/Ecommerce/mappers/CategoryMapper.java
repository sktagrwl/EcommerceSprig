package com.example.Ecommerce.mappers;

import com.example.Ecommerce.dto.CategoryDTO;
import com.example.Ecommerce.entity.Category;

public class CategoryMapper {

    public static CategoryDTO toDto(Category category) {
        return CategoryDTO.builder()
                .name(category.getName())
                .build();
    }

    public static Category toEntity(CategoryDTO categoryDTO) {
        return Category.builder()
                .name(categoryDTO.getName())
                .build();
    }

}
