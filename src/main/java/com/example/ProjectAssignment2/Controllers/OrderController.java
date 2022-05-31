package com.example.ProjectAssignment2.Controllers;

import com.example.ProjectAssignment2.DTO.CustomerDTO;
import com.example.ProjectAssignment2.DTO.OrderDTO;
import com.example.ProjectAssignment2.Services.OrderService;
import com.example.ProjectAssignment2.Services.impl.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/project/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders(){
        return ResponseEntity.ok().body(orderService.getAllOrders());
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO){
        System.out.println(orderDTO.getCustomerId());
        return new ResponseEntity<>(orderService.createCustomer(orderDTO), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@Valid @RequestBody OrderDTO orderDTO, @PathVariable(name = "id") int id){
        return new ResponseEntity<>(orderService.updateOrder(orderDTO,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable(name = "id")int id){
        orderService.deleteOrderById(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }
}
