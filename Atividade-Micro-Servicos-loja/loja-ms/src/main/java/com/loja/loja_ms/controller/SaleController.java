package com.loja.loja_ms.controller;

import com.loja.loja_ms.dtos.SaleCancellDto;
import com.loja.loja_ms.dtos.SaleDetailedDto;
import com.loja.loja_ms.dtos.SaleDto;
import com.loja.loja_ms.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    SaleService saleService;

    @GetMapping("/id")
    public ResponseEntity<SaleDetailedDto> getSaleById(long id) {
        SaleDetailedDto saleDetailedDto = saleService.getSaleById(id);

        if (saleDetailedDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        return ResponseEntity.ok(saleDetailedDto);
    }

    @GetMapping()
    public ResponseEntity<List<SaleDetailedDto>> getAllSales(Pageable page){
        return ResponseEntity.ok(saleService.getAllSales(page));
    }

    @PostMapping()
    public ResponseEntity<SaleDetailedDto> sale(@RequestBody SaleDto saleDto){
        SaleDetailedDto saleDetailedDto = saleService.sale(saleDto);

        if( saleDetailedDto == null )
            return new ResponseEntity<SaleDetailedDto>(HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(saleDetailedDto);
    }
    @PutMapping()
    public ResponseEntity<SaleDetailedDto> cancellSale(@RequestBody SaleCancellDto saleCancellDto){
        SaleDetailedDto saleDetailedDto = saleService.cancellSale(saleCancellDto);

        if( saleDetailedDto == null )
            return new ResponseEntity<SaleDetailedDto>(HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(saleDetailedDto);
    }

}
