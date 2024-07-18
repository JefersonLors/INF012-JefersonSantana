package com.estoque.estoque_ms.services;

import com.estoque.estoque_ms.dtos.ProductDetailedDto;
import com.estoque.estoque_ms.dtos.ProductReportDto;
import com.estoque.estoque_ms.entities.Product;
import com.estoque.estoque_ms.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    ProductRepository productRepository;

    public List<ProductReportDto> getInventoryReport(){
        return  productRepository.findAll().stream().map(ProductReportDto::new).toList();
    }

    public ProductDetailedDto inProduct(long productId, long inventory){
        Optional<Product> productOp = productRepository.findById(productId);

        if(!productOp.isPresent())
            return null;

        Product product = productOp.get();

        product.setInventory(product.getInventory() + inventory);

        return new ProductDetailedDto(productRepository.save(product));
    }

    public ProductDetailedDto outProduct(long productId, long inventory){
        Optional<Product> productOp = productRepository.findById(productId);

        if(!productOp.isPresent())
            return null;

        Product product = productOp.get();

        if( product.getInventory() <= 0 )
            return null;

        if( product.getInventory() - inventory < 0)
            return null;

        product.setInventory(product.getInventory() - inventory);

        return new ProductDetailedDto(productRepository.save(product));
    }
}
