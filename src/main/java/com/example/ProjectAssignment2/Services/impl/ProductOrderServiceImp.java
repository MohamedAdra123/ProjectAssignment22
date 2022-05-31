package com.example.ProjectAssignment2.Services.impl;

import com.example.ProjectAssignment2.DTO.ProductOrderDTO;
import com.example.ProjectAssignment2.Entities.ProductOrder;
import com.example.ProjectAssignment2.Entities.Stock;
import com.example.ProjectAssignment2.Exceptions.ResourceNotFoundException;
import com.example.ProjectAssignment2.Repositories.ProductOrderRepository;
import com.example.ProjectAssignment2.Services.ProductOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductOrderServiceImp implements ProductOrderService {
    private ProductOrderRepository productOrderRepository;

    public ProductOrderServiceImp(ProductOrderRepository productOrderRepository) {
        this.productOrderRepository = productOrderRepository;
    }

    @Override
    public ProductOrderDTO createProductOrder(ProductOrderDTO productOrderDTO) {
        ProductOrder productOrder = convertToEntity(productOrderDTO);
        ProductOrder createdProductOrder = productOrderRepository.save(productOrder);
        ProductOrderDTO productOrderDTOResponse = convertToDTO(createdProductOrder);
        return productOrderDTOResponse;
    }

    @Override
    public List<ProductOrderDTO> getAllProductOrders() {
        List<ProductOrder> productOrders = productOrderRepository.findAll();
        return productOrders.stream().map(productOrder -> convertToDTO(productOrder)).collect(Collectors.toList());
    }

    @Override
    public ProductOrderDTO getProductOrderById(int id) {
        ProductOrder productOrder = productOrderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ProductOrder","id",id));

        return convertToDTO(productOrder);
    }

    @Override
    public ProductOrderDTO updateProductOrder(ProductOrderDTO productOrderDTO, int id) {
        ProductOrder productOrder = productOrderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ProductOrder","id",id));
        productOrder.setProductOrderId(productOrderDTO.getId());
        productOrder.setPrice(productOrderDTO.getPrice());
        productOrder.setProduct(productOrderDTO.getProduct());
        productOrder.setOrder(productOrderDTO.getOrder());
        productOrder.setQuantity(productOrderDTO.getQuantity());
        productOrder.setVat(productOrderDTO.getVat());
        ProductOrder updatedProductOrder = productOrderRepository.save(productOrder);
        return convertToDTO(updatedProductOrder);
    }

    @Override
    public void deleteProductOrderById(int id) {
        ProductOrder productOrder = productOrderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ProductOrder","id",id));
        productOrderRepository.delete(productOrder);
    }
    public ProductOrderDTO convertToDTO(ProductOrder productOrder){
        ProductOrderDTO productOrderDTO = new ProductOrderDTO();
        productOrderDTO.setProduct(productOrder.getProduct());
        productOrderDTO.setOrder(productOrder.getOrder());
        productOrderDTO.setId(productOrder.getProductOrderId());
        productOrderDTO.setPrice(productOrder.getPrice());
        productOrderDTO.setQuantity(productOrder.getQuantity());
        productOrderDTO.setVat(productOrder.getVat());
        return productOrderDTO;
    }
    public ProductOrder convertToEntity(ProductOrderDTO productOrderDTO){
        ProductOrder productOrder = new ProductOrder();
        productOrder.setProduct(productOrderDTO.getProduct());
        productOrder.setOrder(productOrderDTO.getOrder());
        productOrder.setProductOrderId(productOrderDTO.getId());
        productOrder.setPrice(productOrderDTO.getPrice());
        productOrder.setQuantity(productOrderDTO.getQuantity());
        productOrder.setVat(productOrderDTO.getVat());
        return productOrder;
    }
}
