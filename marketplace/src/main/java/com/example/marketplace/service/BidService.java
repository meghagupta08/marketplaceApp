package com.example.marketplace.service;

import com.example.marketplace.model.Bid;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BidService {
    List<Bid> findAllBidsForUser( Long userId);

    Bid findTopBidByItem( Long itemId);

}
