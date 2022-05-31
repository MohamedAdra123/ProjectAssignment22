package com.example.ProjectAssignment2.Repositories;

import com.example.ProjectAssignment2.Entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Integer> {
}
