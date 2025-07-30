package com.example.Ecommerce.controllers;


import com.example.Ecommerce.contollers.ProductByIdController;
import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.entity.Category;
import com.example.Ecommerce.exception.GlobalExceptionHandler;
import com.example.Ecommerce.services.IProductByIdService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
    @Mock
    private IProductByIdService productByIdService;

    @InjectMocks
    private ProductByIdController productByIdController;

    private MockMvc mockMvc;
    private ProductDTO productDTO;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(productByIdController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();

        productDTO = ProductDTO.builder().image("Sample_Nike.jpg").brand("Nike").color("black").model("Jordans")
                .price(20000).title("Nike Air Jordans 1 sneekers").description("Great fashionable shoes")
                .popular(true).discount(10).categoryId(1L).id(1L)
                .build();
    }

    @Test
    @DisplayName("GET /api/products/id/{ProductId} should return product by id")
    void getProductById_shouldReturnProductById() throws Exception {
        //Arrange
        when(productByIdService.getProductById(anyLong())).thenReturn(productDTO);
        //Act
        mockMvc.perform(get("/api/products/id/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.image").value("Sample_Nike.jpg"))
                .andExpect(jsonPath("$.brand").value("Nike"))
                .andExpect(jsonPath("$.color").value("black"));

        //Assert
        verify(productByIdService, times(1)).getProductById(anyLong());
    }








}
