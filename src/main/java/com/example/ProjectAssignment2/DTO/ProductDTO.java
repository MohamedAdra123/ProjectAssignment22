package com.example.ProjectAssignment2.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Data
public class ProductDTO {
    private int id;
    private String slug;
    private String name;
    private String reference;
    @NotNull
    @Size(min=2,max=10)
    private double price;
    @NotNull
    @Size(min=2,max=10)
    private double vat;
    private boolean stockable;
}
