package com.example.Ecommerce.controllers;


import com.example.Ecommerce.contollers.CategoryController;
import com.example.Ecommerce.dto.CategoryDTO;
import com.example.Ecommerce.exception.GlobalExceptionHandler;
import com.example.Ecommerce.services.ICategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {
    @Mock
    private ICategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    private MockMvc mockMvc;
    private CategoryDTO categoryDTO1;
    private CategoryDTO categoryDTO2;
    private CategoryDTO categoryDTO3;
    private String jsonRequestBody;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
        categoryDTO1 = CategoryDTO.builder().name("Audio").id(1L).build();
        categoryDTO2 = CategoryDTO.builder().name("Electronics").id(2L).build();
        categoryDTO3 = CategoryDTO.builder().name("Footwear").id(3L).build();
        jsonRequestBody = """
                {
                    "name":"Audio",
                    "id":1
                }
                """;
    }

    @Test
    @DisplayName("GET /api/categories should return all categories")
    void getAllCategories_shouldReturnAllCategories() throws Exception {
        //Arrange
        List<CategoryDTO> categories = new ArrayList<>();
        categories.add(categoryDTO1);
        categories.add(categoryDTO2);
        categories.add(categoryDTO3);
        when(categoryService.getAllCategories()).thenReturn(categories);
        //Act
        mockMvc.perform(get("/api/categories").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Audio"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Electronics"))
                .andExpect(jsonPath("$[2].id").value(3))
                .andExpect(jsonPath("$[2].name").value("Footwear"));
        //Assert
        verify(categoryService, times(1)).getAllCategories();
    }

    @Test
    @DisplayName("POST /api/categories should create a new Category")
    void createCategory_shouldCreateACategory() throws Exception {
        //Arrange
        when(categoryService.createCategory(any(CategoryDTO.class))).thenReturn(categoryDTO1);

        //Act
        mockMvc.perform(post("/api/categories").contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Audio"));

        //Assert
        verify(categoryService, times(1)).createCategory(any(CategoryDTO.class));

    }
}
