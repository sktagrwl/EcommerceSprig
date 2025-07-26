package com.example.Ecommerce.services;


import com.example.Ecommerce.dto.CategoryDTO;
import com.example.Ecommerce.entity.Category;
import com.example.Ecommerce.repository.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // This annotation is used to enable Mockito for the test class with JUnit
public class CategoryServiceTest {

    @Mock //
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    void name() {
    }

    @Test // mark function as a unit test
    @DisplayName("should return all categories successfully") //custom display message
    void getAllCategories_shouldReturnAllCategories() throws IOException {

        //Arrange
        List<Category> categories = new ArrayList<>();
        Category category1 = Category.builder().name("Electronics").build();
        category1.setId(1L);
        Category category2 = Category.builder().name("Audio").build();
        category2.setId(2L);
        Category category3 = Category.builder().name("footwear").build();
        category3.setId(3L);
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        when(categoryRepository.findAll()).thenReturn(categories); // mocked the repository to return the categories

        //Act
        List<CategoryDTO> result = categoryService.getAllCategories();
        //Assert
        assertEquals(result.size(), 3);
        verify(categoryRepository, times(1)).findAll();
    }

}
