package com.example.springboot001.service;

import com.example.springboot001.entity.Order;

public interface IOrderService {
    String getNo(Long userId);

    Order getOrder(Order order);
}
