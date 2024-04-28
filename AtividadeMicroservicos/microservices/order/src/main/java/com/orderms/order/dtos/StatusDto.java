package com.orderms.order.dtos;

import com.orderms.order.entities.Status;

public record StatusDto(Long id, String description) {
    public StatusDto(Status status){
        this(status.getId(), status.getDescription());
    }
}
