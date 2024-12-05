package com.semicolon.africa.yumzi.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String foodName;
    private String foodType;
    private int quantity;
    @OneToOne
    private User user;

    @OneToMany
    private List<CartItem> items;
}
