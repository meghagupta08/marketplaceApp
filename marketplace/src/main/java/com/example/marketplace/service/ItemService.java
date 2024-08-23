package com.example.marketplace.service;


import com.example.marketplace.model.Item;
import com.example.marketplace.model.User;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item>  findItemByStatus(String status);
    List<Item> findAllListingsForUser(Long id);


}
