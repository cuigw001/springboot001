package com.example.ws.service;

import com.example.ws.entity.ET_RETURN;
import com.example.ws.entity.IT_DATA;
import com.example.ws.entity.Order;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(
        name = "OrderWebService", // 暴露服务名称
        targetNamespace = "http://service.ws.example.com"// 命名空间,一般是接口的包名倒序
)
public interface IOrderWebService {

//@WebResult(name = "String", targetNamespace = "")
    //@WebMethod
    //String greeting(@WebParam(name = "name") String name);

    //exclude声明该方法不发布
    //@WebMethod(exclude = true)
    //String greeting(String name);
   /* @WebMethod(exclude = true)
    String getNo(Long userId);

    @WebMethod(exclude = true)
    List<Order> getOrder(Order order);*/

    @WebMethod
    ET_RETURN syncData(List<IT_DATA> orders);
}
