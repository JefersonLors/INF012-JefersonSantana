package com.loja.loja_ms.services;

import com.loja.loja_ms.dtos.SaleDetailedDto;
import com.loja.loja_ms.dtos.SaleDto;
import com.loja.loja_ms.entities.Sale;
import com.loja.loja_ms.repositories.SaleRepository;
import com.loja.loja_ms.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {
    @Autowired
    SaleRepository saleRepository;

    @Autowired
    SellerRepository sellerRepository;

    public SaleDetailedDto getSaleById(long id){
        Optional<Sale> saleOp = saleRepository.findById(id);

        if(!saleOp.isPresent())
            return null;

        return new SaleDetailedDto(saleOp.get());
    }

    public List<SaleDetailedDto> getAllSales(Pageable page){
        Page<Sale> sales = saleRepository.findAll(page);
        return sales.map(SaleDetailedDto::new).stream().toList();
    }

    public SaleDetailedDto sale(SaleDto saleDto){
        return null;
    }

    public SaleDetailedDto cancellSale(long id){
        return null;
    }
}
