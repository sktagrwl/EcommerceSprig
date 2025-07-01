package com.example.Ecommerce.gateway;

import com.example.Ecommerce.dto.FakeStoreSingleProductResponseDTO;
import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.gateway.api.FakeStoreProductByIdApi;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FakeStoreProductByIdGateway implements IProductByIdGateway{

    private final FakeStoreProductByIdApi fakeStoreProductByIdApi;

    public FakeStoreProductByIdGateway(FakeStoreProductByIdApi fakeStoreProductByIdApi) {
        this.fakeStoreProductByIdApi = fakeStoreProductByIdApi;
    }

    @Override
    public ProductDTO getProductById(Long ProductId) throws IOException {
        FakeStoreSingleProductResponseDTO response = this.fakeStoreProductByIdApi.getFakeProductById(ProductId).execute().body();

        if(response == null) {
            throw new IOException("Unable to fetch a product from fake store Api");
        }

        return response.getProduct();
    }
}
