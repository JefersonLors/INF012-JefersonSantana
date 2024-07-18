package com.estoque.estoque_ms.dtos;

import com.estoque.estoque_ms.entities.Category;

public record CategoryDto(long id, String name) {
    public CategoryDto(Category category){
        this(category.getId(), category.getName());
    }
}
