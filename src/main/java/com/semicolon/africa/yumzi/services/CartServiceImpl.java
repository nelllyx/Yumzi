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
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setId(addCartItemsToACustomerCart.getCustomerId());
                    return cartRepository.save(newCart);
                });
        List<CartItem> cartItem = cartItemRepository.findAllCartItemByUserId(addCartItemsToACustomerCart.getCustomerId());
        List<CartItem> cartItems = cart.getItems();
        cartItems.addAll(cartItem);
        cart.setItems(cartItems);
        cartRepository.save(cart);
        AddCartItemsToACustomerCartResponse response = new AddCartItemsToACustomerCartResponse();
        response.setId(cart.getId());
        response.setMessage("Cart Item Added Successfully In Cart");
        return response;
    }

    @Override
    public RemoveCartItemsToACustomerCartResponse removeCartItemsToACustomerCart(RemoveCartItemsToACustomerCartRequest removeCartItemsToACustomerCart) {
        Cart cart = cartRepository.findCartByUserId(removeCartItemsToACustomerCart.getCustomerId())
                .orElseThrow(() -> new CartNotFoundException("Cart Not Found"));
        List<CartItem> cartItems = cart.getItems();
        for (CartItem cartItem : cartItems) {
            cartItems.remove(cartItem);
        }
        cart.setItems(cartItems);
        cartRepository.save(cart);
        RemoveCartItemsToACustomerCartResponse response = new RemoveCartItemsToACustomerCartResponse();
        response.setMessage("Cart Item Removed Successfully In Cart");
        return response;
    }

    @Override
    public List<FindAllCartItemsInCartResponse> findAllCartItemsInCart(FindAllCartItemsInCartRequest findAllCartItemsInCart) {
        Cart cart = cartRepository.findCartByUserId(findAllCartItemsInCart.getUserId())
                .orElseThrow(() -> new CartNotFoundException("Cart Not Found"));
        List<CartItem> cartItemList = cart.getItems();
        List<FindAllCartItemsInCartResponse> responseList = new ArrayList<>();
        for (CartItem cartItem : cartItemList) {
            FindAllCartItemsInCartResponse response = new FindAllCartItemsInCartResponse();
            response.setFoodType(cartItem.getFoodType());
            response.setQuantity(cartItem.getQuantity());
            response.setFoodType(cartItem.getFoodType());
            responseList.add(response);
        }
        return responseList;
    }
}
