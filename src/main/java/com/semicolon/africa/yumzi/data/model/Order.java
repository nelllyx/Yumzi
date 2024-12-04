package com.semicolon.africa.yumzi.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String foodName;
    private String address;
    private String phone;
    private int quantity;
}