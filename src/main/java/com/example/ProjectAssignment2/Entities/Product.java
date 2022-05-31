package com.example.ProjectAssignment2.Entities;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table

public class Product {
    @GeneratedValue
    @Id
    private int productId;
    @Column
    private String slug;
    @Column
    private String reference;
    @Column
    private String name;
    @Column
    private double price;
    @Column
    private double vat;
    @Column
    private boolean stockable;
}
