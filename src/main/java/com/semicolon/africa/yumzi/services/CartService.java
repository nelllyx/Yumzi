package com.semicolon.africa.yumzi.services;

import com.semicolon.africa.yumzi.data.model.CartItem;
import com.semicolon.africa.yumzi.dtos.request.AddCartItemsToACustomerCartRequest;
import com.semicolon.africa.yumzi.dtos.request.FindAllCartItemsInCartRequest;
import com.semicolon.africa.yumzi.dtos.request.RemoveCartItemsToACustomerCartRequest;
import com.semicolon.africa.yumzi.dtos.response.AddCartItemsToACustomerCartResponse;
import com.semicolon.africa.yumzi.dtos.response.FindAllCartItemsInCartResponse;
import com.semicolon.africa.yumzi.dtos.response.RemoveCartItemsToACustomerCartResponse;

public interface CartService {
    AddCartItemsToACustomerCartResponse addCartItemsToACustomerCart(AddCartItemsToACustomerCartRequest addCartItemsToACustomerCart);
    RemoveCartItemsToACustomerCartResponse removeCartItemsToACustomerCart(RemoveCartItemsToACustomerCartRequest removeCartItemsToACustomerCart);
    FindAllCartItemsInCartResponse findAllCartItemsInCart(FindAllCartItemsInCartRequest findAllCartItemsInCart);
}
