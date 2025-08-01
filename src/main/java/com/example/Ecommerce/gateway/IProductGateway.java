package com.example.Ecommerce.gateway;

import com.example.Ecommerce.dto.ProductDTO;

import java.io.IOException;
import java.util.Map;

public interface IProductGateway {

    Map<Long, ProductDTO> getAllProducts() throws IOException;
}
