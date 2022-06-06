package com.example.ProjectAssignment2.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class ProductOrder {
    @GeneratedValue
    @Id
    private int productOrderId;

    @ManyToOne(targetEntity = Product.class , cascade = {CascadeType.ALL})
    private Product product;

    @ManyToOne(targetEntity = Order.class , cascade = {CascadeType.ALL})
    private Order order;
    @Column
    private int quantity;
    @Column
    private double price;
    @Column
    private double vat;
}
