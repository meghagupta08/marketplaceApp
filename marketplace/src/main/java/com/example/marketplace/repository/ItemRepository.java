package com.example.marketplace.repository;

import com.example.marketplace.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

    Optional<Item> findById(Long itemId);

    @Query(value="SELECT i FROM Item i WHERE i.status=:status")
    List<Item>  findItemByStatus(@Param("status") String status);


    @Query(value = "SELECT i from Item i WHERE i.seller.id=:userId")
    List<Item> findAllListingsForUser(@Param("userId") Long id);

}
