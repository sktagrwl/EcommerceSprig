package com.example.Ecommerce.gateway;

import com.example.Ecommerce.dto.ProductDTO;

import java.io.IOException;
import java.util.Map;

public interface IProductGateway {

    Map<Integer, ProductDTO> getAllProducts() throws IOException;
}
