package com.estoque.estoque_ms.entities;

import com.estoque.estoque_ms.dtos.ProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    Category category;

    String name;

    double price;

    long inventory;

    LocalDateTime ctr_dth_updt;

    public Product(ProductDto productDto){
        this.id = productDto.id();
        this.category = new Category(productDto.codCategory(), null);
        this.name = productDto.name();
        this.price = productDto.price();
        this.inventory = productDto.inventory();
    }
}
