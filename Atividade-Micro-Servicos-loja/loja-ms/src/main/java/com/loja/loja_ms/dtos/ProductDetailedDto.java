package com.loja.loja_ms.dtos;

public record ProductDetailedDto(long id, CategoryDto category, String name, double price, long inventory) {

}
