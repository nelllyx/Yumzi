package com.semicolon.africa.yumzi.services;

import com.semicolon.africa.yumzi.data.model.Cart;
import com.semicolon.africa.yumzi.data.model.Food;
import com.semicolon.africa.yumzi.data.model.User;
import com.semicolon.africa.yumzi.data.repository.FoodRepository;
import com.semicolon.africa.yumzi.data.repository.UserRepository;
import com.semicolon.africa.yumzi.dtos.request.AddFoodRequest;
import com.semicolon.africa.yumzi.dtos.request.RemoveFoodRequest;
import com.semicolon.africa.yumzi.dtos.response.AddFoodResponse;
import com.semicolon.africa.yumzi.dtos.response.RemoveFoodResponse;
import com.semicolon.africa.yumzi.exceptions.FoodNameAlreadyExistException;
import com.semicolon.africa.yumzi.exceptions.FoodNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private FoodRepository foodRepository;

    @Override
    public AddFoodResponse addFood(AddFoodRequest addFoodRequest) {
        validateFood(addFoodRequest.getFoodName());
        Food food = new Food();
            food.setFoodName(addFoodRequest.getFoodName());
            food.setFoodPrice(addFoodRequest.getFoodPrice());
            food.setFoodDescription(addFoodRequest.getFoodDescription());
            foodRepository.save(food);
            AddFoodResponse addFoodResponse = new AddFoodResponse();
            addFoodResponse.setId(food.getId());
            addFoodResponse.setMessage("Food added successfully");
            return addFoodResponse;
        }

    private void validateFood(String foodName) {
        Optional<Food> food = foodRepository.findFoodByFoodName(foodName);
        if (food.isPresent()) {
            throw new FoodNameAlreadyExistException(foodName);
        }
    }

    @Override
    public RemoveFoodResponse removeFood(RemoveFoodRequest removeFoodRequest) {
        Food food = foodRepository.findFoodById(removeFoodRequest.getFoodId())
                .orElseThrow(() -> new FoodNotFoundException("Food Not Found"));
        foodRepository.delete(food);
        RemoveFoodResponse removeFoodResponse = new RemoveFoodResponse();
        removeFoodResponse.setMessage("Food removed successfully");
        return removeFoodResponse;
    }
}
