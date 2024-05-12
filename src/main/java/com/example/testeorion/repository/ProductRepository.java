package com.example.testeorion.repository;

import com.example.testeorion.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    @Query(value = "SELECT * FROM produto WHERE name = ?1", nativeQuery = true)
    Optional<Product> findProductByName(String name);
}
