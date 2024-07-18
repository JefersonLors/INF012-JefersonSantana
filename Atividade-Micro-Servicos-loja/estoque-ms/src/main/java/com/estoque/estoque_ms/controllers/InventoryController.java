package com.estoque.estoque_ms.controllers;

import com.estoque.estoque_ms.dtos.ProductDetailedDto;
import com.estoque.estoque_ms.dtos.ProductReportDto;
import com.estoque.estoque_ms.services.InventoryService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @GetMapping()
    public ResponseEntity<List<ProductReportDto>> getReport(){
        List<ProductReportDto> report = inventoryService.getInventoryReport();

        return ResponseEntity.ok(report);
    }
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
