package com.example.Ecommerce.contollers;

import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.services.ISingleProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping ("/api/products/single")
public class SingleProductController {

    private final ISingleProductService singleProductService;

    public SingleProductController(ISingleProductService singleProductService) {
        this.singleProductService = singleProductService;
    }

    @GetMapping
    public ResponseEntity<ProductDTO> getSingleProduct() throws IOException {
        ProductDTO result = this.singleProductService.getSingleProduct();
        return ResponseEntity.ok(result);
    }
}
