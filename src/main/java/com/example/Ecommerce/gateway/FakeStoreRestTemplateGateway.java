package com.example.Ecommerce.gateway;

import com.example.Ecommerce.dto.CategoryDTO;
import com.example.Ecommerce.dto.FakeStoreCategoryResponseDTO;
import com.example.Ecommerce.mappers.GetAllCategoryMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.util.List;

@Component("FakeStoreRestTemplateGateway")
public class FakeStoreRestTemplateGateway implements ICategoryGateway{



    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreRestTemplateGateway(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Value("${FakeStore.api.url}")
    private String FakeStoreApi;


    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {

        RestTemplate restTemplate = restTemplateBuilder.build();//Rest Template object

        String url = FakeStoreApi + "products/category";

        ResponseEntity<FakeStoreCategoryResponseDTO> response = restTemplate.getForEntity(url, FakeStoreCategoryResponseDTO.class);

        if (response.getBody() == null){
            throw new IOException("Failed to fetch categories from FakeStore API");
        }

        return GetAllCategoryMapper.toCategoryDTO(response.getBody());
    }
}
