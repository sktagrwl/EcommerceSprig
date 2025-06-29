package com.example.Ecommerce.gateway;

import com.example.Ecommerce.dto.CategoryDTO;

import java.io.IOException;
import java.util.*;

public interface ICategoryGateway {

    List<CategoryDTO> getAllCategories() throws IOException;
}
