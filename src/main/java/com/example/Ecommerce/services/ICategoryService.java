package com.example.Ecommerce.services;

import com.example.Ecommerce.dto.AllProductsOfACategoryDTO;
import com.example.Ecommerce.dto.CategoryDTO;

import java.io.IOException;
import java.util.*;

public interface ICategoryService {

    List<CategoryDTO> getAllCategories() throws IOException;

    CategoryDTO createCategory(CategoryDTO categoryDTO) throws IOException;

    CategoryDTO getByName(String name) throws IOException;

    AllProductsOfACategoryDTO getAllProductsOfACategory(Long id) throws IOException;

}
