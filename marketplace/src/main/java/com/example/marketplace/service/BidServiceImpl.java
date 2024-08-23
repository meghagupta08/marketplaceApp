package com.example.marketplace.service;


import com.example.marketplace.model.Bid;
import com.example.marketplace.model.Item;
import com.example.marketplace.model.User;
import com.example.marketplace.repository.BidRepository;
import com.example.marketplace.repository.ItemRepository;
import com.example.marketplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BidServiceImpl  implements BidService{

    @Autowired
    BidRepository bidRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Bid> findAllBidsForUser(Long userId) {
        return bidRepository.findAllBidsForUser(userId);
    }

    @Override
    public Optional<Bid> placeBid(Long userId, double bidAmount, Long itemId) {
        //find the highestBid for an item
        Optional<Bid> highestBid = bidRepository.findTopBidByItem(itemId);
        Optional<Item> item = itemRepository.findById(itemId);
        Optional<User> user = userRepository.findById(userId);
        if(highestBid.isPresent()){
            double currHigestBidAmount = highestBid.get().getBidPrice();
            if(bidAmount<=currHigestBidAmount){
                throw  new IllegalArgumentException("Bid amount less than or equal to current highest bid");
            }else if(!item.get().getStatus().equals("ACTIVE")){
                throw  new IllegalArgumentException("Item is not eligible for placing the bid");
            }
            else{
                Bid newBid = new Bid();
                newBid.setBidPrice(bidAmount);
                newBid.setBidTime(LocalDateTime.now());
                newBid.setItem(item.get());
                newBid.setBidder(user.get());
                bidRepository.save(newBid);
                return Optional.of(newBid);
            }

        }
        return null;
    }

    @Override
    public Optional<Bid> findTopBidByItem(Long itemId) {
        return  bidRepository.findTopBidByItem(itemId);
    }
}
