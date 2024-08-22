package com.example.marketplace.service;

import com.example.marketplace.model.Item;
import com.example.marketplace.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> findItemByStatus(String status) {
        return itemRepository.findItemByStatus(status);
    }

    @Override
    public List<Item> findAllListingsForUser(Long id) {
        return itemRepository.findAllListingsForUser(id);
    }
}
