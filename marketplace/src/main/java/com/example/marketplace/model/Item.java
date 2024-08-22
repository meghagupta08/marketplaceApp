package com.example.marketplace.model;


import com.example.marketplace.config.UserDeserializer;
import com.example.marketplace.enums.ItemStatus;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String itemName;
    private String itemDescription;
    private double buyNowPrice;
    private LocalDateTime startingAuctionTime;
    private LocalDate endAuctionTime;
    private double startingBidPrice;
    private String status;



    @ManyToOne
    @JsonDeserialize(using = UserDeserializer.class)
    private User seller;

    public Item(){

    }

    public void setId(Long id) {
        this.id = id;
    }


    public Item(double buyNowPrice, String itemName, String itemDescription, LocalDateTime startingAuctionTime, LocalDate endAuctionTime, double startingBidPrice, User seller, String status) {
        this.buyNowPrice = buyNowPrice;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.startingAuctionTime = startingAuctionTime;
        this.endAuctionTime = endAuctionTime;
        this.startingBidPrice = startingBidPrice;
        this.seller = seller;
        this.status = status;
    }

    public Item(String itemName, String itemDescription, double buyNowPrice, User seller, String status) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.buyNowPrice = buyNowPrice;
        this.seller = seller;
        this.status = status;
    }


    public Item(String itemName, String itemDescription, User seller, LocalDateTime startingAuctionTime, LocalDate endAuctionTime, double startingBidPrice, String status) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.seller = seller;
        this.startingAuctionTime = startingAuctionTime;
        this.endAuctionTime = endAuctionTime;
        this.startingBidPrice = startingBidPrice;
        this.status = status;
    }


    public Long getId() {
        return id;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getBuyNowPrice() {
        return buyNowPrice;
    }

    public void setBuyNowPrice(double buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
    }

    public LocalDateTime getStartingAuctionTime() {
        return startingAuctionTime;
    }

    public void setStartingAuctionTime(LocalDateTime startingAuctionTime) {
        this.startingAuctionTime = startingAuctionTime;
    }

    public LocalDate getEndAuctionTime() {
        return endAuctionTime;
    }

    public void setEndAuctionTime(LocalDate endAuctionTime) {
        this.endAuctionTime = endAuctionTime;
    }

    public double getStartingBidPrice() {
        return startingBidPrice;
    }

    public void setStartingBidPrice(double startingBidPrice) {
        this.startingBidPrice = startingBidPrice;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
