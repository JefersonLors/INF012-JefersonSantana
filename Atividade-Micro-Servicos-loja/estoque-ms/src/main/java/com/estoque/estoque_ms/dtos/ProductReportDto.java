package com.estoque.estoque_ms.dtos;

import com.estoque.estoque_ms.entities.Product;

import java.time.LocalDateTime;

public record ProductReportDto(String name, String category, long inventory, double price, LocalDateTime ctr_dth_updt) {
    public ProductReportDto(Product product){
        this(product.getName(),
                product.getCategory().getName(),
                product.getInventory(),
                product.getPrice(),
                product.getCtr_dth_updt());
    }
}
