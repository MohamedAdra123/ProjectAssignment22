package com.example.ProjectAssignment2.Controllers;

import com.example.ProjectAssignment2.DTO.ProductOrderDTO;
import com.example.ProjectAssignment2.DTO.StockDTO;
import com.example.ProjectAssignment2.Services.StockService;
import com.example.ProjectAssignment2.Services.impl.StockServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/project/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }
    public ResponseEntity<List<StockDTO>> getAllProducts(){
        return ResponseEntity.ok().body(stockService.getAllStocks());
    }
    @GetMapping("/{id}")
    public ResponseEntity<StockDTO> getProductById(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(stockService.getStockById(id));
    }
    @PostMapping
    public ResponseEntity<StockDTO> createProduct(@RequestBody StockDTO stockDTO){
        return new ResponseEntity<>(stockService.createStock(stockDTO), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StockDTO> updateProduct(@Valid @RequestBody StockDTO stockDTO, @PathVariable(name = "id") int id){
        return new ResponseEntity<>(stockService.updateStock(stockDTO,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(name = "id")int id){
        stockService.deleteStockById(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }
}
