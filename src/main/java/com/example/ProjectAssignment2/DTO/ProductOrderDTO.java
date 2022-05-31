package com.example.ProjectAssignment2.DTO;

import com.example.ProjectAssignment2.Entities.Order;
import com.example.ProjectAssignment2.Entities.Product;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Data
public class ProductOrderDTO {
    private int id;
    private Order order;
    private Product product;
    private int quantity;
    @NotNull
    @Size(min = 2,max = 10)
    private double price;
    @NotNull
    @Size(min = 2,max = 10)
    private double vat;
}
