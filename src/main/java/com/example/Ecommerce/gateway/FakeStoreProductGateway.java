package com.example.Ecommerce.gateway;

import com.example.Ecommerce.dto.FakeStoreProductResponseDTO;
import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.gateway.api.FakeStoreProductApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class FakeStoreProductGateway implements IProductGateway{

    private final FakeStoreProductApi fakeStoreProductApi;

    public FakeStoreProductGateway(FakeStoreProductApi fakeStoreProductApi) {
        this.fakeStoreProductApi = fakeStoreProductApi;
    }
    @Override
    public Map<String , ProductDTO> getAllProducts() throws IOException {

        FakeStoreProductResponseDTO response = this.fakeStoreProductApi.getAllFakeProducts().execute().body();

        if(response == null){
            throw new IOException("failed to fetch Product from fake Store API");

        }

        return response.getProducts().stream()
                .collect(Collectors.toMap(product -> product.id, product -> product));
    }
}
