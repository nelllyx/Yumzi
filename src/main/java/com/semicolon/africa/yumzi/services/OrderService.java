package com.semicolon.africa.yumzi.services;

import com.semicolon.africa.yumzi.dtos.request.CancelOrderRequest;
import com.semicolon.africa.yumzi.dtos.request.MakeOrderRequest;
import com.semicolon.africa.yumzi.dtos.response.CancelOrderResponse;
import com.semicolon.africa.yumzi.dtos.response.MakeOrderResponse;

public interface OrderService {
    MakeOrderResponse makeOrder(MakeOrderRequest request);
    CancelOrderResponse cancelOrder(CancelOrderRequest request);
}
