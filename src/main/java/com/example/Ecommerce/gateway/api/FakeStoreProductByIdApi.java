package com.example.Ecommerce.gateway.api;

import com.example.Ecommerce.dto.FakeStoreSingleProductResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;

public interface FakeStoreProductByIdApi {

    @GET("products/{ProductId}")
    Call<FakeStoreSingleProductResponseDTO> getFakeProductById(@Path("ProductId") Long ProductId) throws IOException;
}
