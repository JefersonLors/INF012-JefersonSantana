package com.estoque.estoque_ms.controllers;

import com.estoque.estoque_ms.dtos.ProductDetailedDto;
import com.estoque.estoque_ms.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @PutMapping("/in/{productId}/{inventory}")
    public ResponseEntity<ProductDetailedDto> inProduct(@PathVariable long productId,
                                                        @PathVariable long inventory){
        ProductDetailedDto productDetailedDto = inventoryService.inProduct(productId, inventory);

        if( productDetailedDto == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(productDetailedDto);
    }

    @PutMapping("/out/{productId}/{inventory}")
    public ResponseEntity<ProductDetailedDto> outProduct(@PathVariable long productId,
                                                        @PathVariable long inventory){
        ProductDetailedDto productDetailedDto = inventoryService.outProduct(productId, inventory);

        if( productDetailedDto == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(productDetailedDto);
    }
}
