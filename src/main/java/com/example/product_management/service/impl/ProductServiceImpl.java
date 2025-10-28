package com.example.product_management.service.impl;

import com.example.product_management.dto.ProductDTO;
import com.example.product_management.model.Product;
import com.example.product_management.repository.ProductRepository;
import com.example.product_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Product addProduct(ProductDTO dto) {
        Product product = mapToEntity(dto);
        return repository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public List<Product> searchProductsByCategory(String category) {
        return repository.findByCategoryIgnoreCase(category);
    }

    @Override
    public void deleteProductByName(String name) {
    Product product = repository.findByProductNameIgnoreCase(name)
        .orElseThrow(() -> new RuntimeException("Product not found: " + name));
    repository.delete(product);
 }


    private Product mapToEntity(ProductDTO dto) {
        Product product = new Product();
        product.setProductName(dto.getProductName());
        product.setCategory(dto.getCategory());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        return product;
    }
}
