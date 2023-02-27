package com.example.springboot001.service.impl;

import com.example.springboot001.entity.Order;
import com.example.springboot001.service.IOrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {


    @Override
    public String getNo(Long userId) {
        return "0001";
    }

    @Override
    public Order getOrder(Order order) {
        return new Order("001", "点卡订单", 1000L);
    }
}
