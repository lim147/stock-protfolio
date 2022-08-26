package com.conygre.spring.boot.rest;

import com.conygre.spring.boot.entities.Stock;
import com.conygre.spring.boot.entities.Transaction;
import com.conygre.spring.boot.services.StockService;
import com.conygre.spring.boot.services.TransactionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collection;

@RestController
@RequestMapping("/api/stocks")
@CrossOrigin
public class StockController {
    @Autowired
    private StockService stockService;

    @Autowired
    private TransactionService transactionService;

    @ApiOperation(value = "getAllStocks", nickname = "getAllStocks")
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @RequestMapping(method = RequestMethod.GET, value = "stock-symbol/{symbol}")
    public Stock getStockbySymbol(@PathVariable("symbol") String symbol) {
        return stockService.getStockBySymbol(symbol);
    }

    @RequestMapping(method = RequestMethod.GET, value = "stock-name/{name}")
    public Stock getStockbyName(@PathVariable("name") String name) {
        return stockService.getStockByName(name);
    }


    @RequestMapping(method = RequestMethod.POST)
    public void buyStock(@RequestBody Stock stock) {
        Transaction vo = transcVO(stock);
        vo.setType("BUY");
        if (stockService.getStockBySymbol(stock.getSymbol()) == null) {
            stockService.buyStock(stock);
            transactionService.addTransaction(vo);
        } else {
            transactionService.addTransaction(vo);
            stockService.addStockQty(stock);
        }
        
        

    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void sellStock(@RequestBody Stock stock) {
        // Make sure the stock to be sold is within the stock portfolio
        if (stockService.getStockBySymbol(stock.getSymbol()) != null){
            Transaction vo = transcVO(stock);
            vo.setType("SELL");
            transactionService.addTransaction(vo);
            int portfolioQty = stockService.getStockBySymbol(stock.getSymbol()).getQty();
            // Make sure the quantity of stock being sold is smaller than the stock number in portfolio
            if (portfolioQty >= stock.getQty()){
                stockService.decreaseStockQty(stock);
            }
            // Otherwise, decrease the stock number in portfolio to 0
            else{
                stockService.decreaseStockQtyToZero(stock);
            }
        }
    }

    private Transaction transcVO(@RequestBody Stock stock) {
        Transaction transcVO = new Transaction();
        transcVO.setStock(stock);
        transcVO.setQty(stock.getQty());
        transcVO.setSubmittedDateTime(LocalDateTime.now());
        transcVO.setSubmittedPrice(stock.getTransactions().get(stock.getTransactions().size() - 1).getSubmittedPrice());
        return transcVO;
    }
}
