package com.estoque.estoque_ms.services;

import com.estoque.estoque_ms.dtos.ProductDto;
import com.estoque.estoque_ms.entities.Category;
import com.estoque.estoque_ms.entities.Product;
import com.estoque.estoque_ms.repositories.CategoryRepository;
import com.estoque.estoque_ms.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public ProductDto getProductById(long id){
        Optional<Product> productOp = productRepository.findById(id);

        if( productOp.isEmpty() )
            return null;

        return new ProductDto(productOp.get());
    }

    public List<ProductDto> getProductByName(String name){
        List<Product> productList = productRepository.findByNameContaining(name);

        return productList.stream().map(ProductDto::new).toList();
    }

    public Page<ProductDto> getAllProducts(Pageable page){
        return productRepository.findAll(page).map(ProductDto::new);
    }

    public ProductDto createProduct(ProductDto productDto){
        Optional<Category> categoryOp = categoryRepository.findById(productDto.category().id());

        if( !categoryOp.isPresent() ){
            return null;
        }

        Product product = productRepository.save(new Product(productDto));

        return new ProductDto(product);
    }

    public ProductDto updateProduct(long id, ProductDto productDto){
        Optional<Product> productOp = productRepository.findById(id);

        Optional<Category> categoryOp = categoryRepository.findById(productDto.category().id());

        if( !categoryOp.isPresent() || !productOp.isPresent())
            return null;

        Product product = productOp.get();

        product.setName(productDto.name());
        product.setCategory(new Category(productDto.category()));
        product.setPrice(productDto.price());
        product.setInventory(productDto.inventory());

        product = productRepository.save(product);

        return new ProductDto(product);
    }

    public ProductDto deleteProduct(long id){
        Optional<Product> productOp = productRepository.findById(id);

        if( productOp.isEmpty() ){
            return null;
        }

        productRepository.deleteById(id);

        return new ProductDto(productOp.get());
    }
}
