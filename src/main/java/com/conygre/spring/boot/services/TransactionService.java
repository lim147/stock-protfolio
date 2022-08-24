package com.conygre.spring.boot.services;

import com.conygre.spring.boot.entities.Transaction;

import java.time.LocalDate;
import java.util.Collection;

public interface TransactionService {

    Collection<Transaction> getAllTransactions();

    Transaction getTransactionById(int id);

    Collection<Transaction> getTransactionsByStockSymbol(String stockSymbol);

    Collection<Transaction> getTransactionsByType(String type);

    Collection<Transaction> getTransactionsBetweenDate(LocalDate startDate, LocalDate endDate);

    Collection<Transaction> getTransactionsBetweenPrice(Double startPrice, Double endPrice);

    void addTransaction(Transaction transaction);
}
