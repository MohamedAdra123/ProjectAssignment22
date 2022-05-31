package com.example.ProjectAssignment2.Services;



import com.example.ProjectAssignment2.DTO.ProductOrderDTO;

import java.util.List;

public interface ProductOrderService {
    ProductOrderDTO createProductOrder(ProductOrderDTO productOrderDTO);
    List<ProductOrderDTO> getAllProductOrders();
    ProductOrderDTO getProductOrderById(int id);
    ProductOrderDTO updateProductOrder(ProductOrderDTO productOrderDTO, int id);
    void deleteProductOrderById(int id);
}
