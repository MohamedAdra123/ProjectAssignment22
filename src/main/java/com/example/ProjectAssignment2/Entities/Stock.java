package com.example.ProjectAssignment2.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class Stock {
    @GeneratedValue
    @Id
    private int stockId;

    @ManyToOne(targetEntity = Product.class)
    private Product product;
    @Column
    private int quantity;
    @Column
    private Date updateAt;
}
