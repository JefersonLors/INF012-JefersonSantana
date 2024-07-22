package com.loja.loja_ms.services;

import com.loja.loja_ms.controller.clients.InventoryClient;
import com.loja.loja_ms.dtos.*;
import com.loja.loja_ms.entities.Sale;
import com.loja.loja_ms.entities.Seller;
import com.loja.loja_ms.repositories.SaleRepository;
import com.loja.loja_ms.repositories.SellerRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {
    @Autowired
    SaleRepository saleRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    InventoryClient inventoryClient;

    @Autowired
    RabbitTemplate rabbitTemplate;
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
        ResponseEntity<ProductDetailedDto> response = inventoryClient.getProductById(saleDto.codProduct());
        Optional<Seller> sellerOp = sellerRepository.findById(saleDto.codSeller());

        if(!response.hasBody())
            return null;

        if( !sellerOp.isPresent() )
            return null;

        ProductDetailedDto productDetailedDto = response.getBody();

        SaleDetailedDto saleDetailedDto = productToSale(productDetailedDto, sellerOp.get());

        Sale sale = saleRepository.save(new Sale(saleDetailedDto));

        response = inventoryClient.outProduct(productDetailedDto.id(), 1);

        if( !response.hasBody())
            return null;

        return new SaleDetailedDto(sale);
    }

    public SaleDetailedDto cancellSale(SaleCancellDto saleCancellDto){
        Optional<Sale> saleOp = saleRepository.findById(saleCancellDto.codSale());
        Optional<Seller> sellerOp = sellerRepository.findById(saleCancellDto.codSeller());

        if( !saleOp.isPresent())
            return null;

        if( !sellerOp.isPresent())
            return null;

        if( !saleOp.get().getActive() )
            return null;


        Sale sale = saleOp.get();


        sale.setActive(false);

        ResponseEntity<ProductDetailedDto> response = inventoryClient.inProduct(sale.getCodProduct(), 1);

        if(!response.hasBody())
            return null;
         EmailDto email = new EmailDto(
                 0,
                 "lors.jeferson@gmail.com",
                 "jeferson.lazy@gmail.com",
                 "Venda realizada",
                 "Mais uma venda realizada",
                 null,
                 null
         );
        rabbitTemplate.convertAndSend("email-queue", email);

        return new SaleDetailedDto(saleRepository.save(sale));
    }

    private SaleDetailedDto productToSale(ProductDetailedDto product, Seller seller){
        return new SaleDetailedDto(
                0,
                product.id(),
                product.category().id(),
                new SellerDto(seller),
                true,
                LocalDateTime.now()
        );
    }
}
