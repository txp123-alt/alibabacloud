package com.itheima.service.impl;

import com.alibaba.fastjson.JSON;
import com.itheima.mapper.ProductMapper;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product selProdyctByID(Integer pid) {
        Product product = productMapper.selectById(pid);
        log.info("查到的对象为：{}", JSON.toJSONString(product));
        return product;
    }
}
