package com.semicolon.africa.yumzi.services;

import com.semicolon.africa.yumzi.dtos.request.*;
import com.semicolon.africa.yumzi.dtos.response.*;

public interface UserService {
 RegisterUserResponse registerUser(RegisterUserRequest register);
 LogInUserResponse logInUser(LogInUserRequest logInUser);
 MakeOrderResponse userCanMakeOrder(MakeOrderRequest makeOrderRequest);
 CancelOrderResponse cancelOrder(CancelOrderRequest cancelOrderRequest);
 CheckOutFoodResponse checkOutFood(CheckOutFoodRequest checkOutFoodRequest);
 AddCartItemsToACustomerCartResponse addCartItemsToACustomerCart(AddCartItemsToACustomerCartRequest addCartItemsToACustomerCart);
 RemoveCartItemsToACustomerCartResponse removeCartItemsToACustomerCart(RemoveCartItemsToACustomerCartRequest removeCartItemsToACustomerCart);
 FindAllCartItemsInCartResponse findAllCartItemsInCart(FindAllCartItemsInCartRequest findAllCartItemsInCart);
}
