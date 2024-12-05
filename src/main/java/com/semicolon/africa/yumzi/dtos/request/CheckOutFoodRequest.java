package com.semicolon.africa.yumzi.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CheckOutFoodRequest {
    private Long userId;
    private Long foodId;
    private String foodName;
    private String foodType;
    private int quantity;
}
