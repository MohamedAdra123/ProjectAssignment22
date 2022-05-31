package com.example.ProjectAssignment2.Services;



import com.example.ProjectAssignment2.DTO.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO createCustomer(OrderDTO orderDTO);
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(int id);
    OrderDTO updateOrder(OrderDTO orderDTO, int id);
    void deleteOrderById(int id);
}
