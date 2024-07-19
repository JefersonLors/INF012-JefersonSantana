package com.loja.loja_ms.dtos;

import com.loja.loja_ms.entities.Sale;

import java.time.LocalDateTime;

public record SaleDetailedDto(long id, long codProduct, long codCategory, SellerDto seller, Boolean active, LocalDateTime dth_sale) {
    public SaleDetailedDto(Sale sale){
        this(sale.getId(), sale.getCodProduct(), sale.getCategoryProduct(), new SellerDto(sale.getSeller()), sale.getActive(), sale.getDth_sale());
    }
}
