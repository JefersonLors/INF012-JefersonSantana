package com.loja.loja_ms.repositories;

import com.loja.loja_ms.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
