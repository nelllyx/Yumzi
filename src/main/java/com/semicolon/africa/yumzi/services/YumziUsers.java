package com.semicolon.africa.yumzi.services;

import com.semicolon.africa.yumzi.data.model.User;
import com.semicolon.africa.yumzi.data.repository.UserRepository;
import com.semicolon.africa.yumzi.dtos.request.RegisterUserRequest;
import com.semicolon.africa.yumzi.dtos.response.RegisterUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class YumziUsers implements UserService{
   private final UserRepository userRepository;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest register) {
        User user = new User();
        user.setName(register.getName());
        user.setEmail(register.getEmail());
        user.setPassword(register.getPassword());
        user.setPhoneNumber(register.getPhoneNumber());
        userRepository.save(user);
        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage("Registration Successful");
        return response;
    }
}
