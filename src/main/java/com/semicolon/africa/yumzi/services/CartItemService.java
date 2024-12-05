package com.semicolon.africa.yumzi.services;

import com.semicolon.africa.yumzi.dtos.request.AddCartItemRequest;
import com.semicolon.africa.yumzi.dtos.request.CheckOutFoodRequest;
import com.semicolon.africa.yumzi.dtos.request.RemoveCartItemRequest;
import com.semicolon.africa.yumzi.dtos.response.AddCartItemResponse;
import com.semicolon.africa.yumzi.dtos.response.CheckOutFoodResponse;
import com.semicolon.africa.yumzi.dtos.response.RemoveCartItemResponse;

public interface CartItemService {
    CheckOutFoodResponse checkOutFood(CheckOutFoodRequest checkOutFood);
    AddCartItemResponse addCartItem(AddCartItemRequest addCartItem);
    RemoveCartItemResponse removeCartItem(RemoveCartItemRequest removeCartItem);
}
