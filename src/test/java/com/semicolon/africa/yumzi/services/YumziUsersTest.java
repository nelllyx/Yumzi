package com.semicolon.africa.yumzi.services;

import com.semicolon.africa.yumzi.data.repository.UserRepository;
import com.semicolon.africa.yumzi.dtos.request.LogInUserRequest;
import com.semicolon.africa.yumzi.dtos.request.RegisterUserRequest;
import com.semicolon.africa.yumzi.dtos.response.LogInUserResponse;
import com.semicolon.africa.yumzi.dtos.response.RegisterUserResponse;
import com.semicolon.africa.yumzi.exceptions.InvalidEmailException;
import com.semicolon.africa.yumzi.exceptions.InvalidPhoneNumberException;
import com.semicolon.africa.yumzi.exceptions.InvalidPhoneNumberValueException;
import com.semicolon.africa.yumzi.exceptions.UserAlreadyExistExceptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class YumziUsersTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Test
    public void testThatUserCanRegister() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setName("Ife");
        registerUserRequest.setPassword("Ifeife");
        registerUserRequest.setEmail("Ife@gmail.com");
        registerUserRequest.setPhoneNumber("08012345678");
        RegisterUserResponse registerUserResponse = userService.registerUser(registerUserRequest);
        assertThat(registerUserResponse.getMessage()).isEqualTo("Registration Successful");
    }
    @Test
    public void testThatUserCannotRegisterWithTheSameEmail() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setName("Nelson");
        registerUserRequest.setPassword("123421");
        registerUserRequest.setEmail("Janet@gmail.com");
        registerUserRequest.setPhoneNumber("08062349608");
        assertThrows(UserAlreadyExistExceptions.class, () -> userService.registerUser(registerUserRequest));
    }
    @Test
    public void testThatUserPhoneNumberMustBeBetween0And9(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setName("Praise");
        registerUserRequest.setPassword("890765");
        registerUserRequest.setEmail("Praise@gmail.com");
        registerUserRequest.setPhoneNumber("asdfghjkloi");
        assertThrows(InvalidPhoneNumberValueException.class, () -> userService.registerUser(registerUserRequest));
    }
    @Test
    public void testThatTheEmailMustBeValid(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setName("Peter");
        registerUserRequest.setPassword("123421");
        registerUserRequest.setEmail("Peter@");
        registerUserRequest.setPhoneNumber("09012309812");
        assertThrows(InvalidEmailException.class, () -> userService.registerUser(registerUserRequest));
    }
    @Test
    public void testThatUserCanLogin() {
        LogInUserRequest logInUserRequest = new LogInUserRequest();
        logInUserRequest.setEmail("Ife@gmail.com");
        logInUserRequest.setPassword("Ifeife");
        LogInUserResponse logInUserResponse = userService.logInUser(logInUserRequest);
        assertThat(logInUserResponse.getMessage()).isEqualTo("Login Successful");
    }
}