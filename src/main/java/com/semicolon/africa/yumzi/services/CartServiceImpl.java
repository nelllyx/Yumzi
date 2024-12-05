package com.semicolon.africa.yumzi.services;

import com.semicolon.africa.yumzi.data.model.Cart;
import com.semicolon.africa.yumzi.data.model.CartItem;
import com.semicolon.africa.yumzi.data.model.User;
import com.semicolon.africa.yumzi.data.repository.CartItemRepository;
import com.semicolon.africa.yumzi.data.repository.CartRepository;
import com.semicolon.africa.yumzi.data.repository.UserRepository;
import com.semicolon.africa.yumzi.dtos.request.AddCartItemsToACustomerCartRequest;
import com.semicolon.africa.yumzi.dtos.request.FindAllCartItemsInCartRequest;
import com.semicolon.africa.yumzi.dtos.request.RemoveCartItemsToACustomerCartRequest;
import com.semicolon.africa.yumzi.dtos.response.AddCartItemsToACustomerCartResponse;
import com.semicolon.africa.yumzi.dtos.response.FindAllCartItemsInCartResponse;
import com.semicolon.africa.yumzi.dtos.response.RemoveCartItemsToACustomerCartResponse;
import com.semicolon.africa.yumzi.exceptions.CartItemNotFoundException;
import com.semicolon.africa.yumzi.exceptions.CartNotFoundException;
import com.semicolon.africa.yumzi.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public AddCartItemsToACustomerCartResponse addCartItemsToACustomerCart(AddCartItemsToACustomerCartRequest addCartItemsToACustomerCart) {
        Cart cart = cartRepository.findCartByUserId(addCartItemsToACustomerCart.getCustomerId())
                .orElseThrow(() -> new CartNotFoundException("Cart not found"));
        CartItem cartItem = cartItemRepository.findCartItemById(addCartItemsToACustomerCart.getCartItemId())
                        .orElseThrow(() -> new CartItemNotFoundException("CartItem Not Found"));
        List<Cart> cartItems = new ArrayList<>();
        if (cartItem.getFoodName().equals(addCartItemsToACustomerCart.getFoodName()) &&
                cartItem.getFoodType().equals(addCartItemsToACustomerCart.getFoodType()) &&
                cartItem.getQuantity() == addCartItemsToACustomerCart.getQuantity()) {
            cart.setFoodName(addCartItemsToACustomerCart.getFoodName());
            cart.setFoodType(addCartItemsToACustomerCart.getFoodType());
            cart.setQuantity(addCartItemsToACustomerCart.getQuantity());
            cartItems.add(cart);
            cartRepository.saveAll(cartItems);
            AddCartItemsToACustomerCartResponse response = new AddCartItemsToACustomerCartResponse();
            response.setId(cart.getId());
            response.setMessage("Cart Item Added Successfully In Cart");
            return response;
        }
        throw new CartItemNotFoundException("Cart Item Not Found");
    }

    @Override
    public RemoveCartItemsToACustomerCartResponse removeCartItemsToACustomerCart(RemoveCartItemsToACustomerCartRequest removeCartItemsToACustomerCart) {
        return null;
    }

    @Override
    public FindAllCartItemsInCartResponse findAllCartItemsInCart(FindAllCartItemsInCartRequest findAllCartItemsInCart) {
        return null;
    }
}
