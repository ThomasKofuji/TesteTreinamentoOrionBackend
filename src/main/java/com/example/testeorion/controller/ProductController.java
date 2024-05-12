package com.example.testeorion.controller;

import com.example.testeorion.model.Product;
import com.example.testeorion.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController{
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> findAllProducts(){ return ResponseEntity.ok(productService.findAllProducts()); }

    @GetMapping("/name")
    public ResponseEntity<Product> findProductByName(@RequestBody Map<String, String> name){
        return ResponseEntity.ok(productService.findProductByName(name));
    }

}