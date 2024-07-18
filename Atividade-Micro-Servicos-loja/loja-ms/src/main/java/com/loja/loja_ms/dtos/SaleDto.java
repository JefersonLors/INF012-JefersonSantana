package com.loja.loja_ms.dtos;

import com.loja.loja_ms.entities.Sale;

public record SaleDto(long codProduct, long userId) {
    public SaleDto(Sale sale){
        this(sale.getCodProduct(),sale.getSeller().getId());
    }
}
