package com.loja.loja_ms.entities;

import com.loja.loja_ms.dtos.SellerDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name="sellers")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;

    public Seller(SellerDto sellerDto){
        this.id = sellerDto.id();
        this.name = sellerDto.name();
    }
}
