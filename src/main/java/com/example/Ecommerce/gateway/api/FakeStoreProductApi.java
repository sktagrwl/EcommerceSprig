package com.example.Ecommerce.gateway.api;

import com.example.Ecommerce.dto.FakeStoreProductResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;

import java.io.IOException;
import java.util.Map;

public interface FakeStoreProductApi {

    @GET("products/category?type=mobile")
    Call<FakeStoreProductResponseDTO> getAllFakeProducts() throws IOException;

}
