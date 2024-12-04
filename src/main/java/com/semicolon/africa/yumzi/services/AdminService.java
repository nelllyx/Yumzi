package com.semicolon.africa.yumzi.services;

import com.semicolon.africa.yumzi.dtos.request.AddFoodRequest;
import com.semicolon.africa.yumzi.dtos.request.RemoveFoodRequest;
import com.semicolon.africa.yumzi.dtos.response.AddFoodResponse;
import com.semicolon.africa.yumzi.dtos.response.RemoveFoodResponse;

public interface AdminService {
    AddFoodResponse addFood(AddFoodRequest addFoodRequest);
    RemoveFoodResponse removeFood(RemoveFoodRequest removeFoodRequest);
}
