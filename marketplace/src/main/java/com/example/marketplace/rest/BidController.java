package com.example.marketplace.rest;

import com.example.marketplace.model.Bid;
import com.example.marketplace.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bid")
public class BidController {

    @Autowired
    BidService bidService;

    @GetMapping("/getTopBid")
    public ResponseEntity<Bid> getTopBid(@RequestParam Long itemId){
        Optional<Bid> bid = bidService.findTopBidByItem(itemId);
        if(bid.isPresent()){
            return  new ResponseEntity<>(bid.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/getAllBidsForUser")
    public ResponseEntity<List<Bid>> getAllBidsForUser(@RequestParam Long userId){
        List<Bid> bids = bidService.findAllBidsForUser(userId);
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }


    @PostMapping("/placeBid")
    public ResponseEntity<Bid> placeBid(@RequestParam Long itemId, @RequestParam Long userId, @RequestParam double bidAmount){

        Optional<Bid> placedBid = bidService.placeBid(userId,bidAmount,itemId);
        if(placedBid.isPresent()){
            return  new ResponseEntity<>(placedBid.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
