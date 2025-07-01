package com.example.Ecommerce.gateway;

import com.example.Ecommerce.dto.ProductDTO;

import java.io.IOException;

public interface ISingleProductGateway {

    ProductDTO getSingleProduct() throws IOException;
}
