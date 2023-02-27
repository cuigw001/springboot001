package com.example.springboot001.service.impl;

import com.example.springboot001.entity.Order;
import com.example.springboot001.service.IOrderWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@WebService(serviceName = "OrderWebService", // 与接口中指定的name一致, 都可以不写
        targetNamespace = "http://service.springboot001.example.com", // 与接口中的命名空间一致,一般是接口的包名倒，都可以不用写
        endpointInterface = "com.example.springboot001.service.IOrderWebService" // 接口类全路径
)
public class OrderWebService implements IOrderWebService {


    @Autowired
    private OrderService orderService;

    @Override
    public String getNo(Long userId) {
        return orderService.getNo(userId);
    }

    @Override
    public List<Order> getOrder(Order order) {
        return Stream.of(orderService.getOrder(order)).collect(Collectors.toList());
    }
}
