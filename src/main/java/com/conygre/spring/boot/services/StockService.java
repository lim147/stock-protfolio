package com.conygre.spring.boot.services;

import com.conygre.spring.boot.entities.Stock;

public interface StockService {
	Iterable<Stock> getAllStocks();
	
	Stock getStockById(int id);
	
	Stock addNewStock(Stock disc);
		
	void deleteStock(int id);
	
	void deleteStock(Stock disc);
	
	Stock updateStock(Stock disc);
}