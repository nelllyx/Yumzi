package com.semicolon.africa.yumzi.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FindAllCartItemsInCartResponse {
    private String foodName;
    private String foodType;
    private int quantity;
}
