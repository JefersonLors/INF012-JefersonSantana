package com.orderms.order.entities;

import com.orderms.order.dtos.ItemDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="items")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    public Item(ItemDto itemDto){
        this.id = itemDto.id();
        this.name = itemDto.name();
        this.price = itemDto.price();
    }
}
