package com.itheima.service.impl;

import com.itheima.domain.Order;
import com.itheima.mapper.OrderMapper;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Override
    public void createOrder(Order order) {
        orderMapper.insert(order);
    }
}
