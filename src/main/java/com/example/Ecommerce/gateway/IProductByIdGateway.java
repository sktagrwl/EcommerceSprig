package com.example.Ecommerce.gateway;

import com.example.Ecommerce.dto.ProductDTO;

import java.io.IOException;

public interface IProductByIdGateway {

    ProductDTO getProductById(Long ProductId) throws IOException;

}
