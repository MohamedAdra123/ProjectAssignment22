package com.example.ProjectAssignment2.Services.impl;

import com.example.ProjectAssignment2.DTO.ProductDTO;
import com.example.ProjectAssignment2.Entities.Product;
import com.example.ProjectAssignment2.Entities.ProductOrder;
import com.example.ProjectAssignment2.Exceptions.ResourceNotFoundException;
import com.example.ProjectAssignment2.Repositories.ProductRepository;
import com.example.ProjectAssignment2.Services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = convertToEntity(productDTO);
        Product createdProduct = productRepository.save(product);
        ProductDTO productDTOResponse = convertToDTO(createdProduct);
        return productDTOResponse;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> convertToDTO(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(int id) {
        Product product = productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product","id",id));

        return convertToDTO(product);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, int id) {
        Product product = productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product","id",id));
        product.setProductId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setReference(productDTO.getReference());
        product.setSlug(productDTO.getSlug());
        product.setStockable(productDTO.isStockable());
        product.setVat(productDTO.getVat());
        Product updatedProduct = productRepository.save(product);
        return convertToDTO(updatedProduct);
    }

    @Override
    public void deleteProductById(int id) {
        Product product = productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product","id",id));
        productRepository.delete(product);
    }
    public ProductDTO convertToDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getProductId());
        productDTO.setPrice(product.getPrice());
        productDTO.setName(product.getName());
        productDTO.setReference(product.getReference());
        productDTO.setSlug(product.getSlug());
        productDTO.setVat(product.getVat());
        productDTO.setStockable(product.isStockable());
        return productDTO;
    }
    public Product convertToEntity(ProductDTO productDTO){
        Product product = new Product();
        product.setProductId(productDTO.getId());
        product.setPrice(productDTO.getPrice());
        product.setName(productDTO.getName());
        product.setReference(productDTO.getReference());
        product.setSlug(productDTO.getSlug());
        product.setVat(productDTO.getVat());
        product.setStockable(productDTO.isStockable());
        return product;
    }
}
