package com.semicolon.africa.yumzi.services;

import com.semicolon.africa.yumzi.dtos.request.AddCartItemRequest;
import com.semicolon.africa.yumzi.dtos.response.AddCartItemResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class CartItemServiceImplTest {
    @Autowired
    private CartItemService cartItemService;

    @Test
    public void testThatCartItemCanAdded() {
        AddCartItemRequest addCartItemRequest = new AddCartItemRequest();
        addCartItemRequest.setFoodId(7L);
        addCartItemRequest.setQuantity(1);
        addCartItemRequest.setFoodName("Rice");
        addCartItemRequest.setUserId(1L);
        addCartItemRequest.setFoodType("food");
        AddCartItemResponse addCartItemResponse = cartItemService.addCartItem(addCartItemRequest);
        assertThat(addCartItemResponse.getMessage()).isEqualTo("Cart item added successfully");
    }
}