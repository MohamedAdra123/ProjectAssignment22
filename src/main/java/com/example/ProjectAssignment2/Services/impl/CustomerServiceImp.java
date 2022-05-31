package com.example.ProjectAssignment2.Services.impl;

import com.example.ProjectAssignment2.DTO.CustomerDTO;
import com.example.ProjectAssignment2.Entities.Customer;
import com.example.ProjectAssignment2.Entities.Stock;
import com.example.ProjectAssignment2.Exceptions.ResourceNotFoundException;
import com.example.ProjectAssignment2.Repositories.CustomerRepository;
import com.example.ProjectAssignment2.Services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImp implements CustomerService {
    private CustomerRepository customerRepository;

    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = convertToEntity(customerDTO);
        Customer customer1 = customerRepository.save(customer);
        CustomerDTO customerDTO1 = convertToDTO(customer1);
        return customerDTO1;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customer -> convertToDTO(customer)).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer","id",id));
        return convertToDTO(customer);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO, int id) {
        Customer customer = customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer","id",id));
        customer.setId(customerDTO.getId());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setBornAt(customerDTO.getBornAt());
       Customer updatedCustomer= customerRepository.save(customer);
        return convertToDTO(updatedCustomer);
    }

    @Override
    public void deleteCustomerById(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer","id",id));
        customerRepository.delete(customer);
    }
    public CustomerDTO convertToDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setBornAt(customer.getBornAt());
        return customerDTO;
    }
    public Customer convertToEntity(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setBornAt(customerDTO.getBornAt());
        return customer;
    }
}
