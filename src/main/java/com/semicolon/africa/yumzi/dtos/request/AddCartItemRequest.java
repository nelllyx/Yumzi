package com.semicolon.africa.yumzi.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddCartItemRequest {
    private Long userId;
    private String foodName;
    private String foodType;
    private int quantity;
}
