package com.example.product_management.service;

import com.example.product_management.dto.ProductDTO;
import com.example.product_management.model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(ProductDTO productDTO);
    List<Product> getAllProducts();
    List<Product> searchProductsByCategory(String category);
    void deleteProductByName(String name);
}
