package com.example.Ecommerce.controllers;


import com.example.Ecommerce.contollers.ProductByIdController;
import com.example.Ecommerce.exception.GlobalExceptionHandler;
import com.example.Ecommerce.services.IProductByIdService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
    @Mock
    private IProductByIdService productByIdService;

    @InjectMocks
    private ProductByIdController productByIdController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(productByIdController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }
}
