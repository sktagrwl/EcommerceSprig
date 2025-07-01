package com.example.Ecommerce.gateway.api;

import com.example.Ecommerce.dto.FakeStoreSingleProductResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;

import java.io.IOException;


public interface FakeStoreSingleProductAPI {

    @GET("products/2")
    Call<FakeStoreSingleProductResponseDTO> getSingleFakeProduct() throws IOException;
}
