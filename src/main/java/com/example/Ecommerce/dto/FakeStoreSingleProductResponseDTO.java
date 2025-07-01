package com.example.Ecommerce.dto;

import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreSingleProductResponseDTO {

    private String status;

    private String message;

    private ProductDTO product;

}
