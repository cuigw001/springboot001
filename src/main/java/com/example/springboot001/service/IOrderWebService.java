package com.example.springboot001.service;

import com.example.springboot001.entity.Order;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(
        name = "OrderWebService", // 暴露服务名称
        targetNamespace = "http://service.springboot001.example.com"// 命名空间,一般是接口的包名倒序
)
public interface IOrderWebService {

//@WebResult(name = "String", targetNamespace = "")
    //@WebMethod
    //String greeting(@WebParam(name = "name") String name);

    //exclude声明该方法不发布
    //@WebMethod(exclude = true)
    //String greeting(String name);
    @WebMethod
    String getNo(Long userId);

    @WebMethod
    List<Order> getOrder(Order order);
}
