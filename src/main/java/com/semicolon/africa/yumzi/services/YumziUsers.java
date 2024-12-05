package com.semicolon.africa.yumzi.services;

import com.semicolon.africa.yumzi.data.model.User;
import com.semicolon.africa.yumzi.data.repository.UserRepository;
import com.semicolon.africa.yumzi.dtos.request.*;
import com.semicolon.africa.yumzi.dtos.response.*;
import com.semicolon.africa.yumzi.exceptions.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class YumziUsers implements UserService{
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private CartService cartService;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest register) {
        validateUser(register.getEmail());
        validateEmail(register.getEmail());
        validatePassword(register.getPassword());
        validatePhonenumber(register.getPhoneNumber());
        validatePhonenumberValue(register.getPhoneNumber());
        User user = new User();
        user.setName(register.getName());
        user.setEmail(register.getEmail());
        user.setPassword(register.getPassword());
        user.setPhoneNumber(register.getPhoneNumber());
        userRepository.save(user);
        RegisterUserResponse response = new RegisterUserResponse();
        response.setUserId(user.getId());
        response.setMessage("Registration Successful");
        return response;
    }

    @Override
    public LogInUserResponse logInUser(LogInUserRequest logInUser) {
        User user = userRepository.findUserByEmail(logInUser.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));
        if(user.getPassword().equals(logInUser.getPassword())) {
            LogInUserResponse response = new LogInUserResponse();
            response.setMessage("Login Successful");
            return response;
         }
        throw new IncorrectPasswordOrEmailException("Incorrect Password Or Email");
    }

    @Override
    public MakeOrderResponse userCanMakeOrder(MakeOrderRequest makeOrderRequest) {
        User user = userRepository.findUserById(makeOrderRequest.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));
        return orderService.makeOrder(makeOrderRequest);
    }

    @Override
    public CancelOrderResponse cancelOrder(CancelOrderRequest cancelOrderRequest) {
        User user = userRepository.findUserById(cancelOrderRequest.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));
        return orderService.cancelOrder(cancelOrderRequest);
    }

    @Override
    public CheckOutFoodResponse checkOutFood(CheckOutFoodRequest checkOutFoodRequest) {
        User user = userRepository.findUserById(checkOutFoodRequest.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));
        return cartItemService.checkOutFood(checkOutFoodRequest);
    }

    @Override
    public AddCartItemsToACustomerCartResponse addCartItemsToACustomerCart(AddCartItemsToACustomerCartRequest addCartItemsToACustomerCart) {
        return cartService.addCartItemsToACustomerCart(addCartItemsToACustomerCart);
    }

    @Override
    public RemoveCartItemsToACustomerCartResponse removeCartItemsToACustomerCart(RemoveCartItemsToACustomerCartRequest removeCartItemsToACustomerCart) {
        return null;
    }

    @Override
    public FindAllCartItemsInCartResponse findAllCartItemsInCart(FindAllCartItemsInCartRequest findAllCartItemsInCart) {
        return null;
    }

    private void validateEmail(String email) {
        int counter = 0;
        for(int count = 0; count < email.length(); count++) {
            if(email.charAt(count) == '@' && email.contains("gmail.com")) {
                counter++;
            }
        }
        if(counter != 1) {
            throw new InvalidEmailException("Invalid Email");
        }
    }

    private void validatePhonenumberValue(String phoneNumber) {
        if(!phoneNumber.matches("\\+?[0-9\\-\\(\\)\\s]+")) {
            throw new InvalidPhoneNumberValueException("Phone number is not valid");
        }
    }

    private void validatePhonenumber(String phoneNumber) {
        Optional<User> user = userRepository.findUserByPhoneNumber(phoneNumber);
        if(user.isPresent()) {
            throw new InvalidPhoneNumberException("User with phone number " + phoneNumber + " already exists");
        }
        if(phoneNumber.length() != 11) {
            throw new InvalidPhoneNumberException("Invalid Phone number");
        }
    }

    private void validatePassword(String password) {
        if(password.length() != 6) {
            throw new InvalidPasswordException("Invalid Password");
        }
    }

    private void validateUser(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        if (user.isPresent()) {
            throw new UserAlreadyExistExceptions("User Already Exist");
        }
    }
}
