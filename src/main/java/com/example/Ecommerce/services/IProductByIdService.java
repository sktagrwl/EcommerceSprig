package com.example.Ecommerce.services;

import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.dto.ProductWithCategoryDTO;

import java.io.IOException;

public interface IProductByIdService {

    ProductDTO getProductById(Long ProductId) throws IOException;

    ProductDTO createProduct(ProductDTO dto) throws IOException;

    ProductWithCategoryDTO getProductWithCategory(Long id) throws IOException;

}
