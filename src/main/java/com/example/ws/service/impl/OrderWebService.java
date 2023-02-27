package com.example.ws.service.impl;

import com.example.ws.entity.ET_RETURN;
import com.example.ws.entity.IT_DATA;
import com.example.ws.entity.Order;
import com.example.ws.service.IOrderWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@WebService(serviceName = "OrderWebService", // 与接口中指定的name一致, 都可以不写
        targetNamespace = "http://service.ws.example.com", // 与接口中的命名空间一致,一般是接口的包名倒，都可以不用写
        endpointInterface = "com.example.ws.service.IOrderWebService" // 接口类全路径
)
public class OrderWebService implements IOrderWebService {


    @Autowired
    private OrderService orderService;

/*    @Override
    @WebMethod(exclude = true)
    public String getNo(Long userId) {
        return orderService.getNo(userId);
    }

    @Override
    @WebMethod(exclude = true)
    public List<Order> getOrder(Order order) {
        return Stream.of(orderService.getOrder(order)).collect(Collectors.toList());
    }*/

    @Override
    public ET_RETURN syncData(List<IT_DATA> orders) {
        ET_RETURN et_return = new ET_RETURN();
        et_return.setMSGID("SUCCESS");
        et_return.setMSGTY("S");
        et_return.setMSGNO(200);
        et_return.setMSGV1("Message Variable1");
        et_return.setMSGV2("Message Variable2");
        et_return.setMSGV3("Message Variable3");
        et_return.setMSGV4("Message Variable4");
        et_return.setLINENO("Lines in parameter");
        return et_return;
    }
}
