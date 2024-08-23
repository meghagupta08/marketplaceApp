package com.example.marketplace.controller;


import com.example.marketplace.model.Bid;
import com.example.marketplace.rest.BidController;
import com.example.marketplace.service.BidService;
import com.example.marketplace.service.BidServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class BidControllerTest {

    @Mock
    private BidService bidService;

    private MockMvc mockMvc;

    @InjectMocks
    private BidController bidController;

    @BeforeEach
    void initialize(){
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bidController).build();
    }

    @Test
    void testGetTopBid() throws Exception {
        Bid bid = new Bid();
        bid.setId(1l);
        bid.setBidTime(LocalDateTime.now());
        bid.setBidPrice(100.00);

        when(bidService.findTopBidByItem(1l)).thenReturn(Optional.of(bid));
        mockMvc.perform(get("/api/bid/getTopBid?itemId=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
           .andExpect(jsonPath("$.bidPrice").value(100.00));

    }

    @Test
    void getAllBidsForUserTest() throws Exception {
        List<Bid> bidList = new ArrayList<>();
        Bid bid1 = new Bid();
        bid1.setId(1l);
        bid1.setBidPrice(50.00);;
        bid1.setBidTime(LocalDateTime.now());

        Bid bid2 = new Bid();
        bid2.setId(2l);
        bid2.setBidPrice(1000.00);;
        bid2.setBidTime(LocalDateTime.now());

        bidList.add(bid1);
        bidList.add(bid2);

        when(bidService.findAllBidsForUser(1l)).thenReturn(bidList);

        mockMvc.perform(get("/api/bid/getAllBidsForUser?userId=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)));
    }

}
