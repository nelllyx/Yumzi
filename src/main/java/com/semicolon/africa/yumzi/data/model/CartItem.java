package com.semicolon.africa.yumzi.data.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Long userId;
    private String foodName;
    private String foodType;
    private int quantity;
}

