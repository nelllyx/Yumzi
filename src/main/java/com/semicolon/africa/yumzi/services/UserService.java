package com.semicolon.africa.yumzi.services;

import com.semicolon.africa.yumzi.dtos.request.*;
import com.semicolon.africa.yumzi.dtos.response.*;

public interface UserService {
 RegisterUserResponse registerUser(RegisterUserRequest register);
 LogInUserResponse logInUser(LogInUserRequest logInUser);
 UserCanMakeOrderResponse userCanMakeOrder(UserCanMakeOrderRequest makeOrderRequest);
 UserCanCancelOrderResponse cancelOrder(UserCanCancelOrderRequest cancelOrderRequest);
}
