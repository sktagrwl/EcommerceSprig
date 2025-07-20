package com.example.Ecommerce.dto;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductWithCategoryDTO {

    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    private long id;
    private String title;
    private String brand;
    private boolean popular;
    private CategoryDTO category;
}
