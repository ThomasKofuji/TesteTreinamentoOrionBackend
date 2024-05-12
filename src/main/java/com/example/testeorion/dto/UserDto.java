package com.example.testeorion.dto;

import lombok.Data;
import java.io.Serializable;
import java.util.List;
@Data
public class UserDto implements Serializable{
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private List<OrderDto> orders;
}
