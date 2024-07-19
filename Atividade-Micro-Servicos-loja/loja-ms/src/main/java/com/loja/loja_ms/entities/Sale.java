package com.loja.loja_ms.entities;

import com.loja.loja_ms.dtos.SaleDetailedDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name="sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    Seller seller;

    long codProduct;

    long categoryProduct;

    Boolean active;

    LocalDateTime dth_sale;

    public Sale(SaleDetailedDto saleDetailedDto){
        this.id = saleDetailedDto.id();
        this.seller = new Seller(saleDetailedDto.seller());
        this.codProduct = saleDetailedDto.codProduct();
        this.categoryProduct = saleDetailedDto.codCategory();
        this.active = true;
        this.dth_sale = LocalDateTime.now();
    }


}
