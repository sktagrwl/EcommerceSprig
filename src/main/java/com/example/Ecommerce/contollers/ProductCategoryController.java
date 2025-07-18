package com.example.Ecommerce.contollers;


import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.services.IProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductCategoryController {

    private final IProductService productService;

    public ProductCategoryController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Map<Long , ProductDTO>> getAllProduct() throws IOException {
        Map<Long , ProductDTO> result = this.productService.getAllProducts();

        return ResponseEntity.ok(result);
    }

}
