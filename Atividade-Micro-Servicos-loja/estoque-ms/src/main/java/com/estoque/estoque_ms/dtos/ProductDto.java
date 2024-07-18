package com.estoque.estoque_ms.dtos;

import com.estoque.estoque_ms.entities.Product;


public record ProductDto(long id, long codCategory, String name, double price, long inventory) {
    public ProductDto(Product product){
        this(product.getId(), product.getCategory().getId(), product.getName(), product.getPrice(), product.getInventory());
    }
}
