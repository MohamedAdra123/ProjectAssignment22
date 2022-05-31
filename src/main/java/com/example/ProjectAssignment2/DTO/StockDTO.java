package com.example.ProjectAssignment2.DTO;

import com.example.ProjectAssignment2.Entities.Product;
import lombok.Data;

import java.util.Date;

@Data
public class StockDTO {
    private int id;
    private Product product;
    private int quantity;
    private Date updateAt;
}
