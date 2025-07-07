package com.example.Ecommerce.mappers;

import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.entity.Product;

public class ProductMapper {

    public static ProductDTO toDto(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .model(product.getModel())
                .title(product.getTitle())
                .category(product.getCategory())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .build();
    }

    public static Product toEntity(ProductDTO dto) {
        return Product.builder()
                .image(dto.getImage())
                .color(dto.getColor())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .model(dto.getModel())
                .title(dto.getTitle())
                .category(dto.getCategory())
                .brand(dto.getBrand())
                .popular(dto.isPopular())
                .build();
    }

}
