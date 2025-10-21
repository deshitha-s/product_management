package com.example.product_management.controller;

import com.example.product_management.dto.ProductDTO;
import com.example.product_management.model.Product;
import com.example.product_management.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody ProductDTO productDTO) {
        Product savedProduct = service.addProduct(productDTO);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(service.getAllProducts());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable String category) {
        return ResponseEntity.ok(service.searchProductsByCategory(category));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteByName(@PathVariable String name) {
        service.deleteProductByName(name);
        return ResponseEntity.ok("Product deleted successfully: " + name);
    }
}
