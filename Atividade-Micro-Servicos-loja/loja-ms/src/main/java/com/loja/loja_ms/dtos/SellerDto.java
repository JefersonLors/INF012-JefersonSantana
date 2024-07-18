package com.loja.loja_ms.dtos;

import com.loja.loja_ms.entities.Seller;

public record SellerDto(long id, String name) {
    public SellerDto(Seller seller){
        this(seller.getId(), seller.getName());
    }
}
