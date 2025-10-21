package com.example.product_management.repository;

import com.example.product_management.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    List<Product> findByCategoryIgnoreCase(String category);

    Optional<Product> findByProductNameIgnoreCase(String productName);

    void deleteByProductNameIgnoreCase(String productName);
}
