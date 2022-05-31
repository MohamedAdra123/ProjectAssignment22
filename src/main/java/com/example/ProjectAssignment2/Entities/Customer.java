package com.example.ProjectAssignment2.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table

public class Customer {
    @GeneratedValue
    @Id
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Date bornAt;
}
