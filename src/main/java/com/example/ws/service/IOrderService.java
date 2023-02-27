package com.example.ws.service;

import com.example.ws.entity.Order;

public interface IOrderService {
    String getNo(Long userId);

    Order getOrder(Order order);
}
