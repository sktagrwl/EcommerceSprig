package com.example.Ecommerce.gateway;

import com.example.Ecommerce.dto.FakeStoreSingleProductResponseDTO;
import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.gateway.api.FakeStoreSingleProductAPI;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FakeStoreSingleProductGateway implements ISingleProductGateway{


    private final FakeStoreSingleProductAPI fakeStoreSingleProductAPI;

    public FakeStoreSingleProductGateway(FakeStoreSingleProductAPI fakeStoreSingleProductAPI) {
        this.fakeStoreSingleProductAPI = fakeStoreSingleProductAPI;
    }


    @Override
    public ProductDTO getSingleProduct() throws IOException {
        FakeStoreSingleProductResponseDTO response = this.fakeStoreSingleProductAPI.getSingleFakeProduct().execute().body();

        if(response == null) {
            throw new IOException("Unable to fetch a single product from fake store Api");
        }

        return response.getProduct();

    }
}
