package com.semicolon.africa.yumzi.services;

import com.semicolon.africa.yumzi.data.model.CartItem;
import com.semicolon.africa.yumzi.data.model.Food;
import com.semicolon.africa.yumzi.data.model.User;
import com.semicolon.africa.yumzi.data.repository.CartItemRepository;
import com.semicolon.africa.yumzi.data.repository.FoodRepository;
import com.semicolon.africa.yumzi.data.repository.UserRepository;
import com.semicolon.africa.yumzi.dtos.request.AddCartItemRequest;
import com.semicolon.africa.yumzi.dtos.request.CheckOutFoodRequest;
import com.semicolon.africa.yumzi.dtos.request.RemoveCartItemRequest;
import com.semicolon.africa.yumzi.dtos.response.AddCartItemResponse;
import com.semicolon.africa.yumzi.dtos.response.CheckOutFoodResponse;
import com.semicolon.africa.yumzi.dtos.response.RemoveCartItemResponse;
import com.semicolon.africa.yumzi.exceptions.FoodNotFoundException;
import com.semicolon.africa.yumzi.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService{
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public CheckOutFoodResponse checkOutFood(CheckOutFoodRequest checkOutFood) {
        Food food = foodRepository.findFoodById(checkOutFood.getFoodId())
                .orElseThrow(() -> new FoodNotFoundException("Food not found"));
        if(food.getFoodName().equals(checkOutFood.getFoodName())){
            CartItem cartItem = new CartItem();
            cartItem.setFoodName(checkOutFood.getFoodName());
            cartItem.setQuantity(checkOutFood.getQuantity());
            cartItem.setFoodType(checkOutFood.getFoodType());
            cartItemRepository.save(cartItem);
            CheckOutFoodResponse response = new CheckOutFoodResponse();
            response.setItemId(cartItem.getId());
            response.setMessage("Checked out successfully");
            return response;
        }
        return null;
    }

    @Override
    public AddCartItemResponse addCartItem(AddCartItemRequest addCartItem) {
        CartItem cartItem = new CartItem();
        User user = userRepository.findUserById(addCartItem.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        cartItem.setFoodName(addCartItem.getFoodName());
        cartItem.setQuantity(addCartItem.getQuantity());
        cartItem.setFoodType(addCartItem.getFoodType());
        cartItemRepository.save(cartItem);
        AddCartItemResponse response = new AddCartItemResponse();
        response.setId(cartItem.getId());
        response.setMessage("Cart item added successfully");
        return response;
    }

    @Override
    public RemoveCartItemResponse removeCartItem(RemoveCartItemRequest removeCartItem) {
        return null;
    }
}
