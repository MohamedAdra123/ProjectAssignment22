package com.example.ProjectAssignment2.DTO;

import com.example.ProjectAssignment2.Entities.Customer;
import lombok.Data;

import java.util.Date;
@Data
public class OrderDTO {
    private int id;
    private Customer customerId;
    private Date orderedAt;
}
