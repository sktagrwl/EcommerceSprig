package com.example.Ecommerce.services;

import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.dto.ProductWithCategoryDTO;
import com.example.Ecommerce.gateway.IProductByIdGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FakeStoreProductByIdService implements IProductByIdService{

    private final IProductByIdGateway productByIdGateway;

    public FakeStoreProductByIdService(IProductByIdGateway productByIdGateway) {
        this.productByIdGateway = productByIdGateway;
    }


    @Override
    public ProductDTO getProductById(Long ProductId) throws IOException {

        return this.productByIdGateway.getProductById(ProductId);

    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) throws IOException {
        return null;
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategory(Long id) throws IOException {

        return null;
    }


}
