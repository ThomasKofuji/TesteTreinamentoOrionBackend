package com.example.testeorion.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private Integer age;

    @OneToMany(mappedBy = "user")
    private List<Orders> orders = new ArrayList<>();
}

