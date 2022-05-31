package com.example.ProjectAssignment2.Services.impl;

import com.example.ProjectAssignment2.DTO.CustomerDTO;
import com.example.ProjectAssignment2.DTO.OrderDTO;
import com.example.ProjectAssignment2.Entities.Customer;
import com.example.ProjectAssignment2.Entities.Order;
import com.example.ProjectAssignment2.Exceptions.ResourceNotFoundException;
import com.example.ProjectAssignment2.Repositories.OrderRepository;
import com.example.ProjectAssignment2.Services.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImp implements OrderService {
    private OrderRepository orderRepository;

    public OrderServiceImp(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDTO createCustomer(OrderDTO orderDTO) {
        Order order = convertToEntity(orderDTO);
        Order createdOrder = orderRepository.save(order);
        OrderDTO orderDTOResponse = convertToDTO(createdOrder);
        return orderDTOResponse;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(order -> convertToDTO(order)).collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(int id) {
        Order order = orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Order","id",id));

        return convertToDTO(order);
    }

    @Override
    public OrderDTO updateOrder(OrderDTO orderDTO, int id) {
        Order order = orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Order","id",id));
        order.setOrderid(orderDTO.getId());
        order.setOrderedAt(orderDTO.getOrderedAt());
        order.setCustomerId(orderDTO.getCustomerId());
        Order updatedOrder=orderRepository.save(order);
        return convertToDTO(updatedOrder);
    }

    @Override
    public void deleteOrderById(int id) {
        Order order = orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Order","id",id));
        orderRepository.delete(order);
    }
    public OrderDTO convertToDTO(Order order){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getOrderid());
        orderDTO.setCustomerId(order.getCustomerId());
        orderDTO.setOrderedAt(order.getOrderedAt());
        return orderDTO;
    }
    public Order convertToEntity(OrderDTO orderDTO){
        Order order = new Order();
        order.setOrderid(orderDTO.getId());
        order.setOrderedAt(orderDTO.getOrderedAt());
        order.setCustomerId(orderDTO.getCustomerId());

        return order;
    }
}
