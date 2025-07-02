package com.example.Ecommerce.gateway;

import com.example.Ecommerce.dto.CategoryDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component("FakeStoreRestTemplateGateway")
public class FakeStoreRestTemplateGateway implements ICategoryGateway{
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return List.of();
    }
}
