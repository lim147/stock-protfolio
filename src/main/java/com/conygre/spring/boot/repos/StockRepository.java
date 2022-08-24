package com.conygre.spring.boot.repos;

import com.conygre.spring.boot.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    public Collection<Stock> findStockByName(String name);
    public Collection<Stock> findStockBySymbol(String symbol);

    @Transactional
    @Modifying
    @Query("update stocks set stocks.qty = stocks.qty+?1 where stocks.symbol = ?2")
    boolean updateStockQty (Integer qty, String symbol);

}
