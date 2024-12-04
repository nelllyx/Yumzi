package com.semicolon.africa.yumzi.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class AddFoodRequest {
    private String foodName;
    private BigDecimal foodPrice;
    private String foodDescription;
}
