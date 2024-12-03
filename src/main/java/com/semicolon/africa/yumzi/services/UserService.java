package com.semicolon.africa.yumzi.services;

import com.semicolon.africa.yumzi.dtos.request.RegisterUserRequest;
import com.semicolon.africa.yumzi.dtos.response.RegisterUserResponse;

public interface UserService {
 RegisterUserResponse registerUser(RegisterUserRequest register);
}
