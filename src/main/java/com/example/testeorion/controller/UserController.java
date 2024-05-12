package com.example.testeorion.controller;

import com.example.testeorion.dto.UserDto;
import com.example.testeorion.model.User;
import com.example.testeorion.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController{
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUser(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PostMapping("/{user_id}/{order_id}")
    public ResponseEntity<UserDto> orders(@PathVariable("user_id") Long idUser, @PathVariable("order_id") Long idOrder){
        return ResponseEntity.ok(userService.orders(idUser, idOrder));
    }
}
