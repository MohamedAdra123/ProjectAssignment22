package com.example.ProjectAssignment2.Services;

import com.example.ProjectAssignment2.DTO.ProductDTO;


import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(int id);
    ProductDTO updateProduct(ProductDTO productDTO, int id);
    void deleteProductById(int id);
}
