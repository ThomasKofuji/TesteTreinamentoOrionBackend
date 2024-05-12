package com.example.testeorion.service;

import com.example.testeorion.exception.ResourceNotFoundException;
import com.example.testeorion.model.Product;
import com.example.testeorion.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService{
    private final ProductRepository productRepository;

    @Transactional
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Product findProductByName(Map<String, String> name){
        return productRepository.findProductByName(name.get("name")).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

}