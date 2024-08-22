package com.example.marketplace.config;

import com.example.marketplace.model.Bid;
import com.example.marketplace.model.Item;
import com.example.marketplace.model.User;
import com.example.marketplace.repository.BidRepository;
import com.example.marketplace.repository.ItemRepository;
import com.example.marketplace.repository.UserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Configuration
public class DataLoader {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BidRepository bidRepository;

    @Autowired
    ItemRepository itemRepository;


    @PostConstruct
    @Transactional
    public void loadData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        // Load Users
        InputStream userStream = new ClassPathResource("data/users.json").getInputStream();
        List<User> users = mapper.readValue(userStream, new TypeReference<List<User>>(){});
        userRepository.saveAll(users);

        // Load Items
        InputStream itemStream = new ClassPathResource("data/items.json").getInputStream();
        List<Item> items = mapper.readValue(itemStream, new TypeReference<List<Item>>(){});
        itemRepository.saveAll(items);

        // Load Bids
        InputStream bidStream = new ClassPathResource("data/bids.json").getInputStream();
        List<Bid> bids = mapper.readValue(bidStream, new TypeReference<List<Bid>>(){});
        bidRepository.saveAll(bids);
    }


}
