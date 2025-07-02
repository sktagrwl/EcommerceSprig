package com.example.Ecommerce.mappers;

import com.example.Ecommerce.dto.CategoryDTO;
import com.example.Ecommerce.dto.FakeStoreCategoryResponseDTO;

import java.util.List;

public class GetAllCategoryMapper {

    public static FakeStoreCategoryResponseDTO toFakeStoreCategoryResponseDTO(){
        return null;
    }

    public static List<CategoryDTO> toCategoryDTO(FakeStoreCategoryResponseDTO dto) {

        return dto.getCategories().stream()
                .map(
                        category -> CategoryDTO.builder()
                                .name(category).build())
                .toList();
    }
}
