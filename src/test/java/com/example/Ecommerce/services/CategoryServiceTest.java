package com.example.Ecommerce.services;


import com.example.Ecommerce.dto.CategoryDTO;
import com.example.Ecommerce.entity.Category;
import com.example.Ecommerce.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // This annotation is used to enable Mockito for the test class with JUnit
public class CategoryServiceTest {

    @Mock //
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    private CategoryDTO categoryDTO;
    private Category category1;
    private Category category2;
    private Category category3;

    @BeforeEach
    void setUp(){
        categoryDTO = CategoryDTO.builder().name("audio").id(1L).build();
        category1 = Category.builder().name("audio").build();
        category2 = Category.builder().name("footwear").build();
        category3 = Category.builder().name("Electronics").build();
    }

    @Test // mark function as a unit test
    @DisplayName("Should return all categories successfully") //custom display message
    void getAllCategories_shouldReturnAllCategories() throws IOException {
        //Arrange
        List<Category> categories = new ArrayList<>();
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        when(categoryRepository.findAll()).thenReturn(categories); // mocked the repository to return the categories
        //Act
        List<CategoryDTO> result = categoryService.getAllCategories(); // service is actually getting called
        //Assert
        assertEquals(result.size(), 3);
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should return a category by name successfully")
    void getCategoryByName_shouldReturnACategoryByName() throws IOException{
        //Arrange
        when(categoryRepository.findByName("audio")).thenReturn(Optional.of(category1));
        //Act
        CategoryDTO result = categoryService.getByName("audio");
        //Assert
        assertEquals(result.getName(), "audio");
    }

    @Test
    @DisplayName("Create new Category successfully")
    void createCategory_shouldCreateCategorySuccessfully() throws IOException {
        //Arrange
        when(categoryRepository.save(any(Category.class))).thenReturn(category1);
        //Act
        CategoryDTO result = categoryService.createCategory(categoryDTO);
        //Assert
        assertEquals(result.getName(), "audio");
        verify(categoryRepository, times(1)).save(any(Category.class));
    }




}
