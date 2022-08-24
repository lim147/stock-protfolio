package com.conygre.spring.boot.services;


import com.conygre.spring.boot.entities.Stock;
import com.conygre.spring.boot.repos.StockRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class StockImpl implements StockService {
    @Autowired
    private StockRepository dao;
    private static final Logger logger = LogManager.getLogger(StockImpl.class);

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Collection<Stock> getAllStocks() {
        logger.info("[INFO]: get all stocks");
        return dao.findAll();
    }

    @Override
    public Collection<Stock> getStockBySymbol(String symbol) {
        logger.info("[INFO]: get all stocks by symbol");
        return dao.findStockBySymbol(symbol);
    }

    @Override
    public Collection<Stock> getStocksByName(String name) {
        logger.info("[INFO]: get all stocks by Name");
        return dao.findStockByName(name);
    }

    @Override
    public void buyStock(Stock stock) {
        logger.info("[INFO]: buy stock");
        dao.save(stock);
    }

    @Override
    public void sellStock(Stock stock) {
        logger.info("[INFO]: sell stock");
        dao.delete(stock);
    }

    @Override
    public void addStockQty(Stock stock) {
        logger.info("[INFO]: add stock qty");
        dao.updateStockQty(stock.getQty(), stock.getSymbol());
    }

}
