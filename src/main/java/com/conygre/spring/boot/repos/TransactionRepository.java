package com.conygre.spring.boot.repos;

import com.conygre.spring.boot.entities.Stock;
import com.conygre.spring.boot.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    public Iterable<Transaction> findBySymbol(String symbol);
}
