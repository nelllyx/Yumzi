package com.semicolon.africa.yumzi.services;

import com.semicolon.africa.yumzi.dtos.request.*;
import com.semicolon.africa.yumzi.dtos.response.AddCartItemsToACustomerCartResponse;
import com.semicolon.africa.yumzi.dtos.response.FindAllCartItemsInCartResponse;
import com.semicolon.africa.yumzi.dtos.response.RegisterUserResponse;
import com.semicolon.africa.yumzi.dtos.response.RemoveCartItemsToACustomerCartResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class CartServiceImplTest {
    @Autowired
    private CartService cartService;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private UserService userService;

    @Test
    public void testThatCartItemsCanBeAddedToTheCart() {
        AddCartItemsToACustomerCartRequest request = new AddCartItemsToACustomerCartRequest();
        request.setCustomerId(3L);
        AddCartItemsToACustomerCartResponse response = cartService.addCartItemsToACustomerCart(request);
        assertThat(response.getMessage()).isEqualTo("Cart Item Added Successfully In Cart");
    }
    @Test
    public void testThatCartItemCanBeDeletedFromCart(){
        RemoveCartItemsToACustomerCartRequest request = new RemoveCartItemsToACustomerCartRequest();
        request.setCustomerId(3L);
        RemoveCartItemsToACustomerCartResponse response = cartService.removeCartItemsToACustomerCart(request);
        assertThat(response.getMessage()).isEqualTo("Cart Item Removed Successfully In Cart");
    }
    @Test
    public void testThatAllCartItemsCanBeFoundToTheCart() {
        FindAllCartItemsInCartRequest findAllCartItemsInCartRequest = new FindAllCartItemsInCartRequest();
        findAllCartItemsInCartRequest.setUserId(3L);
        List<FindAllCartItemsInCartResponse> findAllCartItemsInCartResponse = cartService.findAllCartItemsInCart(findAllCartItemsInCartRequest);
        assertNotNull(findAllCartItemsInCartResponse);
    }
}