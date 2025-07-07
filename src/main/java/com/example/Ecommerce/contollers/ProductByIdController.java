package com.example.Ecommerce.contollers;

import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.services.IProductByIdService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/products/id")
public class ProductByIdController {

    private final IProductByIdService productByIdService;

    public ProductByIdController(
            @Qualifier("ProductService") IProductByIdService productByIdService) {
        this.productByIdService = productByIdService;
    }

    @GetMapping("/{ProductId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long ProductId) throws IOException {

        ProductDTO result = this.productByIdService.getProductById(ProductId);

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto) throws IOException{

        ProductDTO result = this.productByIdService.createProduct(dto);

        return ResponseEntity.ok(result);
    }
}
