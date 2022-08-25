package com.conygre.spring.boot.services;

import com.conygre.spring.boot.entities.Stock;
import java.util.Collection;

public interface StockService {
	Collection<Stock> getAllStocks();

	Stock getStockBySymbol(String symbol);

	Stock getStockByName(String name);

	void buyStock(Stock stock);
	
	void sellStock(Stock stock);

	void addStockQty(Stock stock);
}