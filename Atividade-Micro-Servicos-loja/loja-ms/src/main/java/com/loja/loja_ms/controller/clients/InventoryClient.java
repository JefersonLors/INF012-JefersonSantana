package com.loja.loja_ms.controller.clients;

import com.loja.loja_ms.dtos.ProductDetailedDto;
import com.loja.loja_ms.dtos.ProductReportDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("estoque-ms")
public interface InventoryClient {
    @RequestMapping(method=RequestMethod.GET, value="/inventory")
    ResponseEntity<List<ProductReportDto>> getReport();
    @RequestMapping(method=RequestMethod.GET, value="/inventory/id")
    ResponseEntity<ProductDetailedDto> getProductById(@RequestParam long id);
    @RequestMapping(method=RequestMethod.PUT, value="inventory/in/{productId}/{inventory}")
    ResponseEntity<ProductDetailedDto> inProduct(@PathVariable long productId, @PathVariable long inventory);

    @RequestMapping(method=RequestMethod.PUT, value="inventory/out/{productId}/{inventory}")
    ResponseEntity<ProductDetailedDto> outProduct(@PathVariable long productId, @PathVariable long inventory);
}
