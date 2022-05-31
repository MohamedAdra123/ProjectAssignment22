package com.example.ProjectAssignment2.Services;


import com.example.ProjectAssignment2.DTO.StockDTO;

import java.util.List;

public interface StockService {
    StockDTO createStock(StockDTO stockDTO);
    List<StockDTO> getAllStocks();
    StockDTO getStockById(int id);
    StockDTO updateStock(StockDTO stockDTO, int id);
    void deleteStockById(int id);
}
