package com.example.Ecommerce.services;


import com.example.Ecommerce.dto.ProductDTO;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IProductService {

    Map<String,ProductDTO> getAllProducts() throws IOException;

}
