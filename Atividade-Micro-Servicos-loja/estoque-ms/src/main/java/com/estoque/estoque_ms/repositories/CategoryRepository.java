package com.estoque.estoque_ms.repositories;

import com.estoque.estoque_ms.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
