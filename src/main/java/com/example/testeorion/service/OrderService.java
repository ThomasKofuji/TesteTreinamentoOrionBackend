package com.example.testeorion.service;

import com.example.testeorion.dto.OrderDto;
import com.example.testeorion.exception.ResourceNotFoundException;
import com.example.testeorion.mapper.OrderMapper;
import com.example.testeorion.model.Orders;
import com.example.testeorion.model.Product;
import com.example.testeorion.repository.OrderRepository;
import com.example.testeorion.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService{
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Orders saveOrder(Orders order){
        return orderRepository.save(order);
    }

    public List<Orders> findAllOrders(){
        return orderRepository.findAll();
    }

    public OrderDto products(Long orderId, Long productId) {
        Orders order = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        order.getProducts().add(product);


        return OrderMapper.INSTANCE.toDto(orderRepository.save(order));
    }
}
