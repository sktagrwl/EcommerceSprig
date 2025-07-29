package com.example.Ecommerce.services;


import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.entity.Category;
import com.example.Ecommerce.entity.Product;
import com.example.Ecommerce.repository.CategoryRepository;
import com.example.Ecommerce.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private  ProductService productService;

    private Category category1;
    private Product product1;
    private Product product2;
    private ProductDTO productDTO;

    @BeforeEach
    void setUp(){
        category1 = Category.builder()
                .name("Footwear")
                .build();
        category1.setId(1L);
        product1 = Product.builder()
                .image("Sample_Nike.jpg").brand("Nike").color("black").model("Jordans")
                .price(20000).title("Nike Air Jordans 1 sneekers").description("Great fashionable shoes")
                .popular(true).discount(10).category(category1)
                .build();
        product1.setId(1L);
        product2 = Product.builder()
                .image("Sample_Adidas.jpg").brand("Adidas").color("white").model("Ezzy")
                .price(10000).title("Adidas Ezzys by Ye").description("Great comfortable shoes").popular(true)
                .discount(40).category(category1)
                .build();
        product2.setId(2L);
        productDTO = ProductDTO.builder().image("Sample_Nike.jpg").brand("Nike").color("black").model("Jordans")
                .price(20000).title("Nike Air Jordans 1 sneekers").description("Great fashionable shoes")
                .popular(true).discount(10).categoryId(category1.getId()).id(product1.getId())
                .build();
    }
    @Test
    @DisplayName("Should Return the product for a specific ID successfully")
    void getProductById_shouldReturnProductByAGivenID() throws IOException {
        //Arrange
        when(productRepository.findById(1L)).thenReturn(Optional.of(product1));
        //Act
        ProductDTO result = productService.getProductById(1L);
        //Assert
        assertEquals(result.getBrand(), "Nike");
        assertEquals(result.getPrice(), 20000);
    }
    @Test
    @DisplayName("Should Create a product sucessfully")
    void createProduct_shouldCreateProduct() throws IOException{
        //Arrange
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category1));
        when(productRepository.save(any(Product.class))).thenReturn(product1);
        //Act
        ProductDTO result = productService.createProduct(productDTO);

        //Assert
        assertEquals(result.getId(), 1L);
        assertEquals(result.getCategoryId(), 1L);
    }
}
