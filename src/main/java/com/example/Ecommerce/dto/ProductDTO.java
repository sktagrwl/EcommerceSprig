package com.example.Ecommerce.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    @Getter
    private int id;
    private String title;
    private String category;
    private String brand;
    private boolean popular;


}
