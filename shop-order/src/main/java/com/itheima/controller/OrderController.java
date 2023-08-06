package com.itheima.controller;

import com.alibaba.fastjson.JSON;
import com.itheima.domain.Order;
import com.itheima.domain.Product;
import com.itheima.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    //Http请求工具
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    //下单
    @RequestMapping("/order/product/{pid}")
    public Order order(@PathVariable("pid") Integer pid){
        log.info("接收到{}号商品的下单请求",pid);

        //调用商品微服务查询商品信息
        log.info("开始查询{}商品信息",pid);
        //Product product = restTemplate.getForObject("http://localhost:8081/product/" + pid, Product.class);
        //调用微服务的方式
        List<ServiceInstance> productServerList = discoveryClient.getInstances("service-product");
        ServiceInstance productServer = productServerList.get(0);
        Product product = restTemplate.getForObject("http://"+productServer.getHost()+":"+productServer.getPort()+"/product/" + pid, Product.class);
        log.info("{}商品信息为：{}",pid, JSON.toJSONString(product));

        //创建订单
        Order order = new Order();
        order.setUid(1);
        order.setUsername("测试用户");

        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprece(product.getPprice());
        order.setNumber(1);
        orderService.createOrder(order);
        log.info("创建订单完成,订单信息为：{}",JSON.toJSONString(order));
        return order;
    }

}
