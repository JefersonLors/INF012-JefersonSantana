package com.orderms.order.entities;

import com.orderms.order.dtos.OrderDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name="orders")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Status status;
    @ManyToMany
    private List<Item> items;
    private Long clientId;

    public Order(OrderDto orderDto){
        this.id = orderDto.id();
        this.status = new Status(orderDto.status());
        this.items = orderDto.itemsList().stream().map(Item::new).toList();
        this.clientId = orderDto.clientId();
    }

}
