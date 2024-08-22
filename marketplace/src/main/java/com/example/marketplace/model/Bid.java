package com.example.marketplace.model;

import com.example.marketplace.config.ItemDeserializer;
import com.example.marketplace.config.UserDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Bid {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private double bidPrice;
    private LocalDateTime bidTime;

    @ManyToOne
    @JsonDeserialize(using = UserDeserializer.class)
    private User bidder;

    @ManyToOne
    @JsonDeserialize(using = ItemDeserializer.class)
    private Item item;

    public Bid(){

    }

    public Bid(Long id,double bidPrice, LocalDateTime bidTime, User bidder, Item item) {
        this.bidPrice = bidPrice;
        this.bidTime = bidTime;
        this.bidder = bidder;
        this.item = item;
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public LocalDateTime getBidTime() {
        return bidTime;
    }

    public void setBidTime(LocalDateTime bidTime) {
        this.bidTime = bidTime;
    }

    public User getBidder() {
        return bidder;
    }

    public void setBidder(User bidder) {
        this.bidder = bidder;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
