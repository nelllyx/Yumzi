package com.semicolon.africa.yumzi.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CancelOrderRequest {
    private Long userId;
    private Long orderId;
    private String foodName;
    private String address;
    private String phone;
    private int quantity;
}
