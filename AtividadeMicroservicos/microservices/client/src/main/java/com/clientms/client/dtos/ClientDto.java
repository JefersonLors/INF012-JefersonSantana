package com.clientms.client.dtos;

import com.clientms.client.entities.Client;

public record ClientDto(Long id, String name, String email) {
    public ClientDto(Client client){
        this(client.getId(), client.getName(), client.getEmail());
    }
}
