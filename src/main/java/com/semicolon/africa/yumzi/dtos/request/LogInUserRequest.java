package com.semicolon.africa.yumzi.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LogInUserRequest {
    private String password;
    private String email;
}
