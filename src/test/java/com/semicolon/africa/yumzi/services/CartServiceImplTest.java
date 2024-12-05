package com.semicolon.africa.yumzi.services;

import com.semicolon.africa.yumzi.dtos.request.AddCartItemsToACustomerCartRequest;
import com.semicolon.africa.yumzi.dtos.response.AddCartItemsToACustomerCartResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class CartServiceImplTest {
    @Autowired
    private CartService cartService;

    @Test
    public void testThatCartItemsCanBeAddedToTheCart() {
        AddCartItemsToACustomerCartRequest request = new AddCartItemsToACustomerCartRequest();
        request.setCustomerId(1L);
        request.setCartItemId(1L);
        request.setFoodName("Beans");
        request.setQuantity(1);
        request.setFoodType("Cooked");
        AddCartItemsToACustomerCartResponse response = cartService.addCartItemsToACustomerCart(request);
        assertThat(response.getMessage()).isEqualTo("Cart Item Added Successfully In Cart");
    }
}