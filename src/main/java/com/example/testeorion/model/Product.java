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
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private String description;

    @ManyToMany(mappedBy = "products")
    private List<Orders> orders = new ArrayList<>();
}