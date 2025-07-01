package com.example.Ecommerce.services;

import com.example.Ecommerce.dto.ProductDTO;

import java.io.IOException;

public interface ISingleProductService {

    ProductDTO getSingleProduct() throws IOException;
}
