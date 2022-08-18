package com.conygre.spring.boot.services;

import com.conygre.spring.boot.entities.Stock;
import java.util.Collection;

public interface StockService {
	Collection<Stock> getAllStocks();

/*	Collection<Stock> getLatestTransactions();

	Collection<Stock> getStockBySymbol();

	Collection<Stock> getStocksByName();

	Collection<Stock> getStocksByType();*/

	void buyStock(Stock stock);
	
	void sellStock(Stock stock);
}