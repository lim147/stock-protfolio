package com.conygre.spring.boot.services;

import com.conygre.spring.boot.entities.Transaction;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface TransactionService {

    Collection<Transaction> getAllTransactions();

    Iterable<Transaction> getTransactionBySymbol(String symbol);
}
