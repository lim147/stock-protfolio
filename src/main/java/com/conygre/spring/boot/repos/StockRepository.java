package com.conygre.spring.boot.repos;

import com.conygre.spring.boot.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    Stock findByName(String name);

    Stock findBySymbol(String symbol);

    @Transactional
    @Modifying
    @Query("update Stock s set s.qty = s.qty+?1 where s.symbol = ?2")
    void increaseStockQty(int qty, String symbol);

    @Transactional
    @Modifying
    @Query("update Stock s set s.qty = s.qty-?1 where s.symbol = ?2")
    void decreaseStockQty(int qty, String symbol);

    @Transactional
    @Modifying
    @Query("update Stock s set s.qty = 0 where s.symbol = ?1")
    void decreaseStockQtyToZero(String symbString);

}
