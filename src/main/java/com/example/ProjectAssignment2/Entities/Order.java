package com.example.ProjectAssignment2.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @GeneratedValue
    @Id
    private int orderid;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn
    private Customer customerId;
    @Column
    private Date orderedAt;
}
