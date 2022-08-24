package com.conygre.spring.boot.services;

import com.conygre.spring.boot.entities.Transaction;
import com.conygre.spring.boot.repos.TransactionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Service
public class TransactionImpl implements TransactionService{
    @Autowired
    private TransactionRepository dao;
    private static final Logger logger = LogManager.getLogger(TransactionImpl.class);

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Collection<Transaction> getAllTransactions() {
        logger.info("[INFO]: get all transactions");
        return dao.findAll();
    }

    @Override
    public Transaction getTransactionById(int id) {
        return dao.findById(id);
    }

    @Override
    public Collection<Transaction> getTransactionsByStockSymbol(String stockSymbol) {
        Collection<Transaction> transaction_list = dao.findByStockSymbol(stockSymbol);
        return transaction_list;
    }


    @Override
    public Collection<Transaction> getTransactionsByType(String type) {
        Collection<Transaction> transaction_list = dao.findByType(type);
        return transaction_list;
    }

    @Override
    public Collection<Transaction> getTransactionsBetweenDate(LocalDate startDate, LocalDate endDate) {
        LocalDateTime startDateTime = startDate.atTime(00, 00, 00);
        LocalDateTime endDateTime = endDate.atTime(23, 59, 59);
        Collection<Transaction> transaction_list = dao.findBySubmittedDateTimeBetween(startDateTime, endDateTime);
        return transaction_list;
    }

    @Override
    public Collection<Transaction> getTransactionsBetweenPrice(Double startPrice, Double endPrice) {
        Collection<Transaction> transaction_list = dao.findBySubmittedPriceBetween(startPrice, endPrice);
        return transaction_list;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        dao.save(transaction);
    }

    @Override
    public void deleteTransactionById(Transaction transaction) {
        int id = transaction.getId();
        dao.deleteById(id);
    }
}
