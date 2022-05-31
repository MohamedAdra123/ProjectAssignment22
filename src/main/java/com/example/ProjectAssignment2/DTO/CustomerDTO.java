package com.example.ProjectAssignment2.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerDTO {
    private int id;
    private String firstName;
    private String lastName;
    private Date bornAt;
}
