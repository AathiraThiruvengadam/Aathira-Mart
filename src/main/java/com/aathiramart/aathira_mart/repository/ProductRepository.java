package com.aathiramart.aathira_mart.repository;

import com.aathiramart.aathira_mart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}