package com.conygre.spring.boot.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="stocks")

public class Stock implements Serializable {
    @Id
    @Column(name="symbol")
    private String symbol;

    @Column(name="name") private String name;
    @Column(name="qty") private Integer qty;

    public Stock() {}

    public Stock(String symbol, String name, Integer qty) {
        this.symbol = symbol;
        this.name = name;
        this.qty = qty;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="stock")
    private List<Transaction> transactions;

    @JsonManagedReference
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
}
