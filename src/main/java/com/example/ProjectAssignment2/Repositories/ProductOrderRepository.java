package com.example.ProjectAssignment2.Repositories;

import com.example.ProjectAssignment2.Entities.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder,Integer> {
}
