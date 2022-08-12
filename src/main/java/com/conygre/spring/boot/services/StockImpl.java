package com.conygre.spring.boot.services;


import com.conygre.spring.boot.entities.Stock;
import com.conygre.spring.boot.entities.Stock;
import com.conygre.spring.boot.repos.StockRepository;
import com.conygre.spring.boot.repos.StockRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StockImpl implements StockService {

	@Autowired
	private StockRepository dao;

	private static final Logger logger = LogManager.getLogger(StockImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.conygre.spring.boot.services.IStockService#getCatalog()
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Iterable<Stock> getAllStocks() {
		logger.info("[INFO]: get all stocks");
		return dao.findAll();
	}

	public Stock getStockById(int id) {
		Optional<Stock> stockOptional =  dao.findById(id);
		if (stockOptional.isPresent()) {
			return stockOptional.get();
		}
		else return null;
	}

	@Override
	public Stock addNewStock(Stock disc) {
		disc.setId(0); // assume it is not in the db
		return dao.save(disc);
	}

	@Override
	public Stock updateStock(Stock disc) {
		return dao.save(disc);
	}

	@Override
	public void deleteStock(int id) {
		Stock toBeDeleted = dao.findById(id).get();
		deleteStock(toBeDeleted);

	}

	@Override
	public void deleteStock(Stock disc) {
		dao.delete(disc);
	}
}
