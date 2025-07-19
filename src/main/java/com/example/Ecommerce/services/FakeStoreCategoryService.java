package com.example.Ecommerce.services;

import com.example.Ecommerce.dto.CategoryDTO;
import com.example.Ecommerce.gateway.ICategoryGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService{


    private final ICategoryGateway categoryGateway;

    public FakeStoreCategoryService(
            @Qualifier("FakeStoreRestTemplateGateway") ICategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }


    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return this.categoryGateway.getAllCategories();
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) throws IOException {
        //Not Implementing
        return null;
    }

    @Override
    public CategoryDTO getByName(String name) throws IOException {
        //Not Implementing
        return null;
    }
}
