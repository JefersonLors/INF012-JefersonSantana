package com.orderms.order.dtos;

import com.orderms.order.entities.Item;

public record ItemDto(Long id, String name, Double price) {
    public ItemDto(Item item){
        this(item.getId(), item.getName(), item.getPrice());
    }
}
