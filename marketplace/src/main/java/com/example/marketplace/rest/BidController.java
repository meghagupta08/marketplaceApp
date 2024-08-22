package com.example.marketplace.rest;

import com.example.marketplace.model.Bid;
import com.example.marketplace.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bid")
public class BidController {

    @Autowired
    BidService bidService;

    @GetMapping("/getTopBid")
    public ResponseEntity<Bid> getTopBid(@RequestParam Long itemId){
        Bid bid = bidService.findTopBidByItem(itemId);
        return  new ResponseEntity<>(bid, HttpStatus.OK);
    }


    @GetMapping("/getAllBidsForUser")
    public ResponseEntity<List<Bid>> getAllBidsForUser(@RequestParam Long userId){
        List<Bid> bids = bidService.findAllBidsForUser(userId);
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }

}
