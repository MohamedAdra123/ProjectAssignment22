package com.example.ProjectAssignment2.Controllers;

import com.example.ProjectAssignment2.DTO.CustomerDTO;
import com.example.ProjectAssignment2.Services.CustomerService;
import com.example.ProjectAssignment2.Services.impl.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/project/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        return ResponseEntity.ok().body(customerService.getAllCustomers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<>(customerService.createCustomer(customerDTO),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@Valid @RequestBody CustomerDTO customerDTO,@PathVariable(name = "id") int id){
        return new ResponseEntity<>(customerService.updateCustomer(customerDTO,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(name = "id")int id){
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }
}
