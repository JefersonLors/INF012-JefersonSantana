package com.estoque.estoque_ms.controllers;

import com.estoque.estoque_ms.dtos.ProductDetailedDto;
import com.estoque.estoque_ms.dtos.ProductDto;
import com.estoque.estoque_ms.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/name")
    public ResponseEntity<List<ProductDetailedDto>> getProductByName(@RequestParam String name){
        List<ProductDetailedDto> productDetailedDto = productService.getProductByName(name);

        if(productDetailedDto == null)
            return new ResponseEntity<List<ProductDetailedDto>>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(productDetailedDto);
    }

    @GetMapping()
    public ResponseEntity<Page<ProductDetailedDto>> getAllProducts(Pageable page){
        return ResponseEntity.ok(productService.getAllProducts(page));
    }

    @PostMapping()
    public ResponseEntity<ProductDetailedDto> createProduct(@RequestBody ProductDto productDto, UriComponentsBuilder uriBuilder){
        ProductDetailedDto productDetailedDto = productService.createProduct(productDto);

        if( productDto == null )
            return new ResponseEntity<ProductDetailedDto>(HttpStatus.BAD_REQUEST);

        URI location =  uriBuilder.path("/{id}").buildAndExpand(productDetailedDto).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDetailedDto> updateProduct(@PathVariable long id,
                                                    @RequestBody ProductDto productDto){
        ProductDetailedDto productDetailedDto = productService.updateProduct(id, productDto);

        if( productDto == null )
            return new ResponseEntity<ProductDetailedDto>(HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(productDetailedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDetailedDto> deleteProduct(@PathVariable long id){
        ProductDetailedDto productDetailedDto  = productService.deleteProduct(id);

        if( productDetailedDto == null )
            return new ResponseEntity<ProductDetailedDto>(HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(productDetailedDto);
    }
}
