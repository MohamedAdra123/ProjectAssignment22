package com.example.ProjectAssignment2.Repositories;

import com.example.ProjectAssignment2.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
