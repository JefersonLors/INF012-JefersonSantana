package com.orderms.order.dtos;

import com.orderms.order.entities.Order;

import java.util.List;

public record OrderDto(Long id, StatusDto status, List<ItemDto> itemsList, Long clientId) {
    public OrderDto(Order order){
        this(order.getId(), new StatusDto(order.getStatus()), order.getItems().stream().map(ItemDto::new).toList(), order.getClientId());
    }
}
