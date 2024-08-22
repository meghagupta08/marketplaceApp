package com.example.marketplace.config;

import com.example.marketplace.model.Item;
import com.example.marketplace.model.User;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;

public class ItemDeserializer extends JsonDeserializer<Item> {

    @Override
    public Item deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Long id = p.getLongValue();
        Item item = new Item();
        item.setId(id);
        return item;
    }
}
