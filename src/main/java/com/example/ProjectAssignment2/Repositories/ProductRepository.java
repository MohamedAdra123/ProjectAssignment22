package com.example.ProjectAssignment2.Repositories;

import com.example.ProjectAssignment2.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
