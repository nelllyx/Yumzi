package com.semicolon.africa.yumzi.controllers;

import com.semicolon.africa.yumzi.dtos.request.RegisterUserRequest;
import com.semicolon.africa.yumzi.dtos.response.ApiResponse;
import com.semicolon.africa.yumzi.dtos.response.RegisterUserResponse;
import com.semicolon.africa.yumzi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/")
public class YumziUsersController {
    private final UserService userService;

    public YumziUsersController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserRequest register) {
        try {
            RegisterUserResponse response = userService.registerUser(register);
            return new ResponseEntity<>(new ApiResponse(response, true), HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
    }
}
