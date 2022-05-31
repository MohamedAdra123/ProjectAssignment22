package com.example.ProjectAssignment2.Services;

import com.example.ProjectAssignment2.DTO.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(int id);
    CustomerDTO updateCustomer(CustomerDTO customerDTO,int id);
    void deleteCustomerById(int id);
}
