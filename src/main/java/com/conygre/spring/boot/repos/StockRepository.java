package com.conygre.spring.boot.repos;

import com.conygre.spring.boot.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    public Iterable<Stock> findStockByName(String name);
    public Iterable<Stock> findStockBySymbol(String symbol);
    public Iterable<Stock> getAllTransactionsBySymbol(String symbol);

}
