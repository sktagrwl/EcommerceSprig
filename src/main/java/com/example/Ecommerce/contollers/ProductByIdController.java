package com.example.Ecommerce.contollers;

import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.services.IProductByIdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/products/id")
public class ProductByIdController {

    private final IProductByIdService productByIdService;

    public ProductByIdController(IProductByIdService productByIdService) {
        this.productByIdService = productByIdService;
    }

    @GetMapping("/{ProductId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long ProductId) throws IOException {

        ProductDTO result = this.productByIdService.getProductById(ProductId);

        return ResponseEntity.ok(result);

    }
}
