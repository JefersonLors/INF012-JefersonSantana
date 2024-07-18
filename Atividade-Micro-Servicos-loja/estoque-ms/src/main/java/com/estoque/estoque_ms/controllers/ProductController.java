package com.estoque.estoque_ms.controllers;

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

    @GetMapping("/id")
    public ResponseEntity<ProductDto> getProductById(@RequestParam long id){
        ProductDto productDto = productService.getProductById(id);

        if(productDto == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(productDto);
    }

    @GetMapping("/name")
    public ResponseEntity<List<ProductDto>> getProductByName(@RequestParam String name){
        List<ProductDto> productDtoList = productService.getProductByName(name);

        if(productDtoList == null)
            return new ResponseEntity<List<ProductDto>>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(productDtoList);
    }

    @GetMapping()
    public ResponseEntity<Page<ProductDto>> getAllProducts(Pageable page){
        return ResponseEntity.ok(productService.getAllProducts(page));
    }

    @PostMapping()
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto, UriComponentsBuilder uriBuilder){
        productDto = productService.createProduct(productDto);

        if( productDto == null )
            return new ResponseEntity<ProductDto>(HttpStatus.BAD_REQUEST);

        URI location =  uriBuilder.path("/{id}").buildAndExpand(productDto).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable long id,
                                                    @RequestBody ProductDto productDto){
        productDto = productService.updateProduct(id, productDto);

        if( productDto == null )
            return new ResponseEntity<ProductDto>(HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDto> deleteProduct(@PathVariable long id){
        ProductDto productDto = productService.deleteProduct(id);

        if( productDto == null )
            return new ResponseEntity<ProductDto>(HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(productDto);
    }
}
