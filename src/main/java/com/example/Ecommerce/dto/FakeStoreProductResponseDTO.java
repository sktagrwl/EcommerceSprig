package com.example.Ecommerce.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FakeStoreProductResponseDTO {

    private String status;

    private String message;

    private List<ProductDTO> products;

}
