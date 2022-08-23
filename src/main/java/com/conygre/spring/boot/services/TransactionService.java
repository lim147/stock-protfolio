package com.conygre.spring.boot.services;

import com.conygre.spring.boot.entities.Transaction;
import java.util.Collection;

public interface TransactionService {

    Collection<Transaction> getAllTransactions();

    Iterable<Transaction> getTransactionByStockSymbol(String stockSymbol);

    Transaction getTransactionById(int id);
}
