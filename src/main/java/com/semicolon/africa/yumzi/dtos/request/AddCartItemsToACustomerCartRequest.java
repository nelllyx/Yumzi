package com.semicolon.africa.yumzi.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddCartItemsToACustomerCartRequest {
    private Long cartItemId;
    private Long customerId;
    private int quantity;
    private String foodName;
    private String foodType;
}
