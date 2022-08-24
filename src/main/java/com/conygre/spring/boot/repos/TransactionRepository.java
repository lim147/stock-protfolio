package com.conygre.spring.boot.repos;

import com.conygre.spring.boot.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    public Transaction findById(int id);
    public Collection<Transaction> findByStockSymbol(String stockSymbol);
    public Collection<Transaction> findByType(String type);
    public Collection<Transaction> findBySubmittedDateTimeBetween(LocalDateTime start, LocalDateTime end);
    public Collection<Transaction> findBySubmittedPriceBetween(Double start, Double end);
}
