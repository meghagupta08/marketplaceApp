package com.example.marketplace.service;


import com.example.marketplace.model.Bid;
import com.example.marketplace.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BidServiceImpl  implements BidService{

    @Autowired
    BidRepository bidRepository;

    @Override
    public List<Bid> findAllBidsForUser(Long userId) {
        return bidRepository.findAllBidsForUser(userId);
    }

    @Override
    public Bid findTopBidByItem(Long itemId) {
        return  bidRepository.findTopBidByItem(itemId);
    }
}
