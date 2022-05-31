package com.example.ProjectAssignment2.Controllers;

import com.example.ProjectAssignment2.DTO.ProductDTO;
import com.example.ProjectAssignment2.DTO.ProductOrderDTO;
import com.example.ProjectAssignment2.Services.ProductOrderService;
import com.example.ProjectAssignment2.Services.impl.ProductOrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/project/productOrder")
public class ProductOrderController {
    @Autowired
    private ProductOrderService productOrderService;

    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }
    @GetMapping
    public ResponseEntity<List<ProductOrderDTO>> getAllProducts(){
        return ResponseEntity.ok().body(productOrderService.getAllProductOrders());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductOrderDTO> getProductById(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(productOrderService.getProductOrderById(id));
    }
    @PostMapping
    public ResponseEntity<ProductOrderDTO> createProduct(@RequestBody ProductOrderDTO productOrderDTO){
        return new ResponseEntity<>(productOrderService.createProductOrder(productOrderDTO), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductOrderDTO> updateProduct(@Valid @RequestBody ProductOrderDTO productOrderDTO, @PathVariable(name = "id") int id){
        return new ResponseEntity<>(productOrderService.updateProductOrder(productOrderDTO,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(name = "id")int id){
        productOrderService.deleteProductOrderById(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }
}
