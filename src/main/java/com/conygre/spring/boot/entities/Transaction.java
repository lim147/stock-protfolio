package com.conygre.spring.boot.entities;

import com.conygre.spring.boot.serializer.TransactionSerializer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name="transactions")
@JsonSerialize(using = TransactionSerializer.class)
public class Transaction implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id") private int id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="stock_symbol")
    private Stock stock;

    @Column(name="submitted_date_time") private LocalDateTime submittedDateTime;
    @Column(name="submitted_price") private Double submittedPrice;
    @Column(name="qty") private Integer qty;
    @Column(name="type") private String type;

    public Transaction() {}

    public Transaction(int id, Stock stock, LocalDateTime submittedDateTime, Double submittedPrice, Integer qty, String type) {
        this.id = id;
        this.stock = stock;
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

    @JsonBackReference
    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
