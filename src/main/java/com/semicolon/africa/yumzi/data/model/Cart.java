package com.semicolon.africa.yumzi.data.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
public class Cart {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @OneToOne
    private User user;
    @ManyToOne
    private CustomerOrder order;

}
