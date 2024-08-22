package com.example.marketplace.rest;

import com.example.marketplace.model.Item;
import com.example.marketplace.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/getAllActiveItems")
    public ResponseEntity<List<Item>> getAllActiveItems(@RequestParam String status){
        List<Item> items =itemService.findItemByStatus(status);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/getListingForUser")
    public ResponseEntity<List<Item>> getAllListingForUser(@RequestParam Long id){
        List<Item> items =itemService.findAllListingsForUser(id);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

}
