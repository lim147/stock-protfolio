// This entity class uses annotations instead of the mapping XML file

package com.conygre.spring.boot.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


// add an annotations specifying the table that this will map to
@Entity @Table(name="stock")

// Adding caching
//@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
//@Cacheable

// ensure that the class implements Serializable


// TODO: do we need this JPQL query?
//@NamedQueries(
//        {
//                @NamedQuery(name="stock.getAll",
//                        query="select cd from Stock as cd where cd.price > :price",
//                        hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")})
//        })



public class Stock implements Serializable {


    // add an attribute specifying a column for the id property
    // add attributes to ensure that the id column is automantically generated
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    // add attributes for all the remaining properties
    @Column(name="symbol") private String symbol;
    @Column(name="name") private String name;
    @Column(name="submitted_price") private Double submittedPrice;
    @Column(name="submitted_date_time") private LocalDateTime submittedDateTime;
    @Column(name="qty") private Integer qty;
    @Column(name="type") private Integer type;


    public Stock() {}

    public Stock(int id, String symbol, String name, Double submittedPrice, LocalDateTime submittedDateTime, Integer qty, Integer type) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.submittedPrice = submittedPrice;
        this.submittedDateTime = submittedDateTime;
        this.qty = qty;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Double getSubmittedPrice() {
        return submittedPrice;
    }

    public void setSubmittedPrice(Double submittedPrice) {
        this.submittedPrice = submittedPrice;
    }

    public LocalDateTime getSubmittedDateTime() {
        return submittedDateTime;
    }

    public void setSubmittedDateTime(LocalDateTime submittedDateTime) {
        this.submittedDateTime = submittedDateTime;
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
