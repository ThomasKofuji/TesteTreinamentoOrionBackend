package com.example.testeorion.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderDto implements Serializable{
    private Long id;
    private String name;
    private Double price;
    private String description;
    private UserDto user;
    private List<ProductDto> products;
}
