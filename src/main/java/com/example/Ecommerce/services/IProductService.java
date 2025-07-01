package com.example.Ecommerce.services;


import com.example.Ecommerce.dto.ProductDTO;

import java.io.IOException;
import java.util.Map;

public interface IProductService {

    Map<Integer,ProductDTO> getAllProducts() throws IOException;

}
