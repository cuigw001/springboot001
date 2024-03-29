package com.example.ws.config;

import com.example.ws.service.impl.OrderWebService;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
@Slf4j
public class CxfConfig {
    @Autowired
    private OrderWebService orderWebService;

    @Value("${server.port}")
    private String port;
    private static final String path = "/ws";
    /**
     * Apache CXF 核心架构是以BUS为核心，整合其他组件。
     * Bus是CXF的主干, 为共享资源提供一个可配置的场所，作用类似于Spring的ApplicationContext，这些共享资源包括
     * WSDl管理器、绑定工厂等。通过对BUS进行扩展，可以方便地容纳自己的资源，或者替换现有的资源。默认Bus实现基于Spring架构，
     * 通过依赖注入，在运行时将组件串联起来。BusFactory负责Bus的创建。默认的BusFactory是SpringBusFactory，对应于默认
     * 的Bus实现。在构造过程中，SpringBusFactory会搜索META-INF/cxf（包含在 CXF 的jar中）下的所有bean配置文件。
     * 根据这些配置文件构建一个ApplicationContext。开发者也可以提供自己的配置文件来定制Bus。
     */
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }


    /**
     * 此方法作用是改变项目中服务名的前缀名，此处127.0.0.1或者localhost不能访问时，请使用ipconfig查看本机ip来访问
     * 此方法被注释后, 即不改变前缀名(默认是services), wsdl访问地址为 http://127.0.0.1:8080/services/ws/api?wsdl
     * 去掉注释后wsdl访问地址为：http://127.0.0.1:8080/soap/ws/api?wsdl
     * http://127.0.0.1:8080/soap/列出服务列表 或 http://127.0.0.1:8080/soap/ws/api?wsdl 查看实际的服务
     * 新建Servlet记得需要在启动类添加注解：@ServletComponentScan
     * <p>
     * 如果启动时出现错误：not loaded because DispatcherServlet Registration found non dispatcher servlet dispatcherServlet
     * 可能是springboot与cfx版本不兼容。
     * 同时在spring boot2.0.6之后的版本与xcf集成，不需要在定义以下方法，直接在application.properties配置文件中添加：
     * cxf.path=/service（默认是services）
     */
    /*@Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/soap/*");
    }*/

    /**
     * 发布服务
     *
     * @return
     */
    @Bean
    public Endpoint userServiceEndpoint() {
        log.info("web service 服务发布");
        //这里指定的端口不能跟应用的端口冲突, 单独指定
        //String path = "http://localhost:9090/ws";

        EndpointImpl userEndpoint = new EndpointImpl(springBus(), orderWebService);
        userEndpoint.publish(path);

        log.info("在线的wsdl:http://localhost:{}/services{}?wsdl",port,path);
        return userEndpoint;
    }
}
