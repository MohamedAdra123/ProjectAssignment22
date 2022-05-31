package com.example.ProjectAssignment2.Repositories;

import com.example.ProjectAssignment2.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
