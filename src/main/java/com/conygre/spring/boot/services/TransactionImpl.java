package com.conygre.spring.boot.services;

import com.conygre.spring.boot.entities.Transaction;
import com.conygre.spring.boot.repos.TransactionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
    public Iterable<Transaction> getTransactionByStockSymbol(String stockSymbol) {
        Iterable<Transaction> transaction_list = dao.findByStockSymbol(stockSymbol);
        return transaction_list;
    }
}
