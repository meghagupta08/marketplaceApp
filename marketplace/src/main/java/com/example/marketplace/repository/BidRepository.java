package com.example.marketplace.repository;


import com.example.marketplace.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {

    @Query("SELECT b from Bid b WHERE b.bidder.id=:UserId")
    List<Bid> findAllBidsForUser(@Param("UserId") Long userId);

    @Query("SELECT b FROM Bid b WHERE b.item.id = :itemId AND b.bidPrice = (SELECT MAX(b2.bidPrice) FROM Bid b2 WHERE b2.item.id = :itemId)")
    Bid findTopBidByItem(@Param("itemId") Long itemId);

}
