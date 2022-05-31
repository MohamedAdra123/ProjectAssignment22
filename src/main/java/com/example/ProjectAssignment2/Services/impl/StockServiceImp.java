package com.example.ProjectAssignment2.Services.impl;

import com.example.ProjectAssignment2.DTO.StockDTO;
import com.example.ProjectAssignment2.Entities.Stock;
import com.example.ProjectAssignment2.Exceptions.ResourceNotFoundException;
import com.example.ProjectAssignment2.Repositories.StockRepository;
import com.example.ProjectAssignment2.Services.StockService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockServiceImp implements StockService {
    private StockRepository stockRepository;

    public StockServiceImp(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public StockDTO createStock(StockDTO stockDTO) {
        Stock stock = convertToEntity(stockDTO);
        Stock stockResponse = stockRepository.save(stock);
        StockDTO stockResponseDTO = convertToDTO(stockResponse);
        return stockResponseDTO;
    }

    @Override
    public List<StockDTO> getAllStocks() {
        List<Stock> stocks = stockRepository.findAll();
        return stocks.stream().map(stock -> convertToDTO(stock)).collect(Collectors.toList());
    }

    @Override
    public StockDTO getStockById(int id) {
        Stock stock = stockRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Stock","id",id));
        return convertToDTO(stock);
    }

    @Override
    public StockDTO updateStock(StockDTO stockDTO, int id) {
        Stock stock = stockRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Stock","id",id));
        stock.setStockId(stockDTO.getId());
        stock.setUpdateAt(stockDTO.getUpdateAt());
        stock.setProduct(stockDTO.getProduct());
        stock.setQuantity(stockDTO.getQuantity());
        Stock updatedStock = stockRepository.save(stock);
        return convertToDTO(updatedStock);
    }

    @Override
    public void deleteStockById(int id) {
        Stock stock = stockRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Stock","id",id));
        stockRepository.delete(stock);
    }
    public StockDTO convertToDTO(Stock stock){
        StockDTO stockDTO = new StockDTO();
        stockDTO.setId(stock.getStockId());
        stockDTO.setProduct(stock.getProduct());
        stockDTO.setQuantity(stock.getQuantity());
        stockDTO.setUpdateAt(stock.getUpdateAt());
        return stockDTO;
    }
    public Stock convertToEntity(StockDTO stockDTO){
        Stock stock= new Stock();
        stock.setStockId(stockDTO.getId());
        stock.setProduct(stockDTO.getProduct());
        stock.setQuantity(stockDTO.getQuantity());
        stock.setUpdateAt(stockDTO.getUpdateAt());
        return stock;
    }
}
