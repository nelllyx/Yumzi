package com.semicolon.africa.yumzi.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequest {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
}
