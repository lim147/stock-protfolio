package com.conygre.spring.boot.services;

import com.conygre.spring.boot.entities.Stock;
import java.util.Collection;

public interface StockService {
	Collection<Stock> getAllStocks();

/*	Collection<Stock> getLatestTransactions();

	Collection<Stock> getStocksByType();
 */

	Iterable<Stock> getStockBySymbol(String symbol);

	Iterable<Stock> getStocksByName(String name);


	void buyStock(Stock stock);
	
	void sellStock(Stock stock);
}