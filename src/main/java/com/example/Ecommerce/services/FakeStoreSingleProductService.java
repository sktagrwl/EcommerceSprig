package com.example.Ecommerce.services;


import com.example.Ecommerce.dto.ProductDTO;

import com.example.Ecommerce.gateway.ISingleProductGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreSingleProductService implements ISingleProductService{

    private final ISingleProductGateway singleProductGateway;

    public FakeStoreSingleProductService(ISingleProductGateway singleProductGateway) {
        this.singleProductGateway = singleProductGateway;
    }


    @Override
    public ProductDTO getSingleProduct() throws IOException {
        return this.singleProductGateway.getSingleProduct();
    }

}
