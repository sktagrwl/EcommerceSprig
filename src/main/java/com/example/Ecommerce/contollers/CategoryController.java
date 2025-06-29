package com.example.Ecommerce.contollers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class  CategoryController {

    @GetMapping
    public String getCategory() {
        return "Electronics";
    }

    @GetMapping("/count")
    public int getCategoryCount() {
        return 5;
    }

    @DeleteMapping
    public String deleteCategory() {
        return "Category deleted";
    }

}
