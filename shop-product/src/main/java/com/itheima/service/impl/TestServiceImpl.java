package com.itheima.service.impl;

import com.alibaba.fastjson.JSON;
import com.itheima.aspect.DscTransaction;
import com.itheima.domain.User;
import com.itheima.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestServiceImpl implements TestService {

    @Override
    @DscTransaction
    public void saveBach(User user) {
        log.info("数据开始入库,需要入库的数据为：{}", JSON.toJSONString(user));
        throw new RuntimeException("测试异常");
    }
}
