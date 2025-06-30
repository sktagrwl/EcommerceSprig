package com.example.Ecommerce.gateway;

import com.example.Ecommerce.dto.ProductDTO;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IProductGateway {

    Map<String, ProductDTO> getAllProducts() throws IOException;
}
