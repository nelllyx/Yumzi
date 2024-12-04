package com.semicolon.africa.yumzi.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String foodName;
    private BigDecimal foodPrice;
    private String foodDescription;
}
