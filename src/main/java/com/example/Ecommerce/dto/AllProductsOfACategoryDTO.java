package com.example.Ecommerce.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllProductsOfACategoryDTO {

    private Long id;

    private String name;

    private List<ProductDTO> products;

}
