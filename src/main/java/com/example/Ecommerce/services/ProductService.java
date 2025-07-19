package com.example.Ecommerce.services;

import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.entity.Category;
import com.example.Ecommerce.entity.Product;
import com.example.Ecommerce.mappers.ProductMapper;
import com.example.Ecommerce.repository.CategoryRepository;
import com.example.Ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("ProductService")
public class ProductService implements IProductByIdService{


    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public ProductDTO getProductById(Long ProductId) throws IOException {
        return productRepository.findById(ProductId)
                .map(ProductMapper::toDto)
                .orElseThrow(() -> new IOException("Product not found"));
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) throws IOException {

        //whenever a product is created we need to verify that category is valid, so that mapping of product and category is not destroyed
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new IOException("Category not found"));

        //only when we get a valid category we will first hit the repository layer
        //to hit the repository layer we need to have an entity so we will convert the dto to entity
        Product saved = productRepository.save(ProductMapper.toEntity(dto, category));

        //and then we will convert the entity to DTO and return
        return ProductMapper.toDto(saved);

    }
}