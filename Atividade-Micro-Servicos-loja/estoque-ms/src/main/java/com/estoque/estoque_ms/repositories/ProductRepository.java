package com.estoque.estoque_ms.repositories;

import com.estoque.estoque_ms.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "Select p from products p where p.name like %:name%")
    List<Product> findByName(@Param("name") String name);

    List<Product> findByNameContaining(String name);
}
