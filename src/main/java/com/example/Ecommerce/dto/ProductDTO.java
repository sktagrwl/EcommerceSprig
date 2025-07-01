package com.example.Ecommerce.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    public  String id,
            title ,
            image ,
            price ,
            description,
            brand,
            model,
            color,
            category,
            discount,
            onSale;


}
