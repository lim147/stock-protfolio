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
    public Collection<Stock> getStocksbySymbol(@PathVariable("symbol") String symbol) {
        return stockService.getStockBySymbol(symbol);
    }

    @RequestMapping(method = RequestMethod.GET, value = "stock-name/{name}")
    public Collection<Stock> getStocksbyName(@PathVariable("name") String name) {
        return stockService.getStocksByName(name);
    }


    @RequestMapping(method = RequestMethod.POST)
    public void buyStock(@RequestBody Stock stock) {
        if (stockService.getStockBySymbol(stock.getSymbol()).isEmpty()) {
            stockService.buyStock(stock);
        } else {
            stockService.addStockQty(stock);
        }
        Transaction vo = transcVO(stock);
        vo.setType("BUY");
        transactionService.addTransaction(vo);

    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void sellStock(@RequestBody Stock stock) {
        stockService.sellStock(stock);
        Transaction vo = transcVO(stock);
        vo.setType("SELL");
        transactionService.addTransaction(vo);

    }

    private Transaction transcVO(@RequestBody Stock stock) {
        Transaction transcVO = new Transaction();
        transcVO.setStock(stock);
        transcVO.setQty(stock.getQty());
        transcVO.setSubmittedDateTime(LocalDateTime.now());
        transcVO.setSubmittedPrice(19.99);
        return transcVO;
    }
}
