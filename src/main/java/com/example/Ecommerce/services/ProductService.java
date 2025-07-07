package com.example.Ecommerce.services;

import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.entity.Product;
import com.example.Ecommerce.mappers.ProductMapper;
import com.example.Ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("ProductService")
public class ProductService implements IProductByIdService{


    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }


    @Override
    public ProductDTO getProductById(Long ProductId) throws IOException {
        return productRepository.findById(ProductId)
                .map(ProductMapper::toDto)
                .orElseThrow(() -> new IOException("Product not found"));
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) throws IOException {
        Product saved = productRepository.save(ProductMapper.toEntity(dto));
        return ProductMapper.toDto(saved);

    }
}