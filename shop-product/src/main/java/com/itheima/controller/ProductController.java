package com.itheima.controller;

import com.alibaba.fastjson.JSON;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping("/product/{pid}")
    public Product selProdyctByID(@PathVariable("pid") Integer pid){
        log.info("开始查询产品ID为：{}的数据",pid);
        Product product = productService.selProdyctByID(pid);
        log.info("查询到的商品数据为：{}",JSON.toJSONString(product));
        return product;
    }

}
