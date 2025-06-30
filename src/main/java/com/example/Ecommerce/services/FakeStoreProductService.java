package com.example.Ecommerce.services;

import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.gateway.IProductGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class FakeStoreProductService implements IProductService{

    private final IProductGateway productGateway;

    public FakeStoreProductService(IProductGateway productGateway) {
        this.productGateway = productGateway;
    }


    @Override
    public Map<String, ProductDTO> getAllProducts() throws IOException {
        return this.productGateway.getAllProducts();
    }
}
