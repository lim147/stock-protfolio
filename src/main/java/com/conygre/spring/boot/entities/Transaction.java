package com.conygre.spring.boot.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="transactions")

public class Transaction implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="symbol") private String symbol;
    @Column(name="submitted_date_time") private LocalDateTime submittedDateTime;
    @Column(name="submitted_price") private Double submittedPrice;
    @Column(name="qty") private Integer qty;
    @Column(name="type") private Integer type;

    public Transaction() {}

    public Transaction(int id, String symbol, LocalDateTime submittedDateTime, Double submittedPrice, Integer qty, Integer type) {
        this.id = id;
        this.symbol = symbol;
        this.submittedDateTime = submittedDateTime;
        this.submittedPrice = submittedPrice;
        this.qty = qty;
        this.type = type;
    }

    public Integer getId(){
        return id;
    }
    
    public void setId(Integer s){
        id = s;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public LocalDateTime getSubmittedDateTime() {
        return submittedDateTime;
    }

    public void setSubmittedDateTime(LocalDateTime submittedDateTime) {
        this.submittedDateTime = submittedDateTime;
    }

    public Double getSubmittedPrice() {
        return submittedPrice;
    }

    public void setSubmittedPrice(Double submittedPrice) {
        this.submittedPrice = submittedPrice;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
