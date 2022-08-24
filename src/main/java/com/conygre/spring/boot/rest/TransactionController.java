package com.conygre.spring.boot.rest;

import com.conygre.spring.boot.entities.Transaction;
import com.conygre.spring.boot.services.TransactionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin
public class TransactionController{
    @Autowired
    private TransactionService service;

    @ApiOperation(value = "getAllTransactions", nickname = "getAllTransactions")
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Transaction> getAllTransactions() {
        return service.getAllTransactions();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Transaction getTransactionById(@PathVariable("id") int id) {
        return service.getTransactionById(id);
    }

    // Filter transaction based on conditions:
    @RequestMapping(method = RequestMethod.GET, value = "stock-symbol/{stock_symbol}")
    public Collection<Transaction> getTransactionsByStockSymbol(@PathVariable("stock_symbol") String stockSymbol) {
        return service.getTransactionsByStockSymbol(stockSymbol);
    }

    @RequestMapping(method = RequestMethod.GET, value = "type/{type}")
    public Collection<Transaction> getTransactionsByType(@PathVariable("type") String type) {
        return service.getTransactionsByType(type);
    }

    @RequestMapping(method = RequestMethod.GET, value = "submitted-date-between/{startDate}/{endDate}")
    public Collection<Transaction> getTransactionsBetweenDate(
            @PathVariable("startDate") String start, @PathVariable("endDate") String end) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        return service.getTransactionsBetweenDate(startDate, endDate);
    }

    @RequestMapping(method = RequestMethod.GET, value = "submitted-price-between/{startPrice}/{endPrice}")
    public Collection<Transaction> getTransactionsBetweenPrice(
            @PathVariable("startPrice") Double start, @PathVariable("endPrice") Double end) {
        return service.getTransactionsBetweenPrice(start, end);
    }

    // Add transaction:
    @RequestMapping(method = RequestMethod.POST)
    public void addTransaction(@RequestBody Transaction transaction) {
        service.addTransaction(transaction);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteTransactionById(@RequestBody Transaction transaction) {
        service.deleteTransactionById(transaction);
    }


}
