package com.estoque.estoque_ms.services;

import com.estoque.estoque_ms.dtos.ProductDetailedDto;
import com.estoque.estoque_ms.dtos.ProductDto;
import com.estoque.estoque_ms.entities.Category;
import com.estoque.estoque_ms.entities.Product;
import com.estoque.estoque_ms.repositories.CategoryRepository;
import com.estoque.estoque_ms.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public ProductDetailedDto getProductById(long id){
        Optional<Product> productOp = productRepository.findById(id);

        if( productOp.isEmpty() )
            return null;

        return new ProductDetailedDto(productOp.get());
    }

    public List<ProductDetailedDto> getProductByName(String name){
        List<Product> productList = productRepository.findByNameContaining(name);

        return productList.stream().map(ProductDetailedDto::new).toList();
    }

    public Page<ProductDetailedDto> getAllProducts(Pageable page){
        return productRepository.findAll(page).map(ProductDetailedDto::new);
    }

    public ProductDetailedDto createProduct(ProductDto productDto){
        Optional<Category> categoryOp = categoryRepository.findById(productDto.codCategory());

        if( !categoryOp.isPresent() ){
            return null;
        }

        Product product = productRepository.save(new Product(productDto));

        return new ProductDetailedDto(product);
    }

    public ProductDetailedDto updateProduct(long id, ProductDto productDto){
        Optional<Product> productOp = productRepository.findById(id);

        Optional<Category> categoryOp = categoryRepository.findById(productDto.codCategory());

        if( !categoryOp.isPresent() || !productOp.isPresent())
            return null;

        Product product = productOp.get();

        product.setName(productDto.name());
        product.setCategory(categoryOp.get());
        product.setPrice(productDto.price());
        product.setInventory(productDto.inventory());

        product = productRepository.save(product);

        return new ProductDetailedDto(product);
    }

    public ProductDetailedDto deleteProduct(long id){
        Optional<Product> productOp = productRepository.findById(id);

        if( productOp.isEmpty() ){
            return null;
        }

        productRepository.deleteById(id);

        return new ProductDetailedDto(productOp.get());
    }
}
