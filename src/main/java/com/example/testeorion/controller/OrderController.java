package com.example.testeorion.controller;

import com.example.testeorion.dto.OrderDto;
import com.example.testeorion.model.Orders;
import com.example.testeorion.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController{
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Orders> saveOrder(@RequestBody Orders order){
        return new ResponseEntity<>(orderService.saveOrder(order), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Orders>> findAllOrders(){ return ResponseEntity.ok(orderService.findAllOrders()); }

    @PostMapping("{order_id}/{product_id}")
    public ResponseEntity<OrderDto> products(@PathVariable("order_id") Long idOrder, @PathVariable("product_id") Long idProduct){
        return ResponseEntity.ok(orderService.products(idOrder, idProduct));
    }

}