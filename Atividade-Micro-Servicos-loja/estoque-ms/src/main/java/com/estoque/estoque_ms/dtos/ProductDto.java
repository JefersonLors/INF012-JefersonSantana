package com.estoque.estoque_ms.dtos;

import com.estoque.estoque_ms.entities.Product;

public record ProductDto(long id, CategoryDto category, String name, double price, long inventory) {
    public ProductDto(Product product){
        this(product.getId(), new CategoryDto(product.getCategory()), product.getName(), product.getPrice(), product.getInventory());
    }
}
