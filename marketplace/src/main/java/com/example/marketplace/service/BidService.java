package com.example.marketplace.service;

import com.example.marketplace.model.Bid;

import java.util.List;
import java.util.Optional;

public interface BidService {
    List<Bid> findAllBidsForUser( Long userId);

    Optional<Bid> findTopBidByItem( Long itemId);

    Optional<Bid> placeBid(Long userId, double bidAmount, Long itemId);

}
