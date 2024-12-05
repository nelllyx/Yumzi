package com.semicolon.africa.yumzi.services;

import com.semicolon.africa.yumzi.data.model.Cart;
import com.semicolon.africa.yumzi.data.model.Food;
import com.semicolon.africa.yumzi.data.model.Order;
import com.semicolon.africa.yumzi.data.repository.CartRepository;
import com.semicolon.africa.yumzi.data.repository.FoodRepository;
import com.semicolon.africa.yumzi.data.repository.OrderRepository;
import com.semicolon.africa.yumzi.dtos.request.CancelOrderRequest;
import com.semicolon.africa.yumzi.dtos.request.MakeOrderRequest;
import com.semicolon.africa.yumzi.dtos.response.CancelOrderResponse;
import com.semicolon.africa.yumzi.dtos.response.MakeOrderResponse;
import com.semicolon.africa.yumzi.exceptions.CartNotFoundException;
import com.semicolon.africa.yumzi.exceptions.FoodNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private CartRepository cartRepository;


    @Override
    public MakeOrderResponse makeOrder(MakeOrderRequest request) {
        Cart cart = cartRepository.findCartByUserId(request.getOrderId())
                .orElseThrow(() -> new CartNotFoundException("Cart not found"));
        Order order = new Order();
        order.setUserName(request.getUserName());
        order.setFoodName(request.getFoodName());
        order.setAddress(request.getAddress());
        order.setPhone(request.getPhone());
        order.setQuantity(request.getQuantity());
        orderRepository.save(order);
        MakeOrderResponse response = new MakeOrderResponse();
        response.setId(order.getId());
        response.setMessage("Order made successfully");
        return response;
    }

    @Override
    public CancelOrderResponse cancelOrder(CancelOrderRequest request) {
        Order order = orderRepository.findOrderById(request.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));
        orderRepository.delete(order);
        CancelOrderResponse response = new CancelOrderResponse();
        response.setMessage("Order cancelled successfully");
        return response;
    }
}
