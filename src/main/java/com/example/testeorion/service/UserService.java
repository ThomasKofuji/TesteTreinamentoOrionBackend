package com.example.testeorion.service;

import com.example.testeorion.dto.UserDto;
import com.example.testeorion.exception.ResourceNotFoundException;
import com.example.testeorion.mapper.UserMapper;
import com.example.testeorion.model.Orders;
import com.example.testeorion.model.User;
import com.example.testeorion.repository.OrderRepository;
import com.example.testeorion.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService{
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Transactional
    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public UserDto orders(Long idUser, Long idOrder){
        User user = userRepository.findById(idUser).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Orders order = orderRepository.findById(idOrder).orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        user.getOrders().add(order);

        return UserMapper.INSTANCE.toDto(userRepository.save(user));
    }
}
