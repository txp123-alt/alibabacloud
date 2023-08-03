package com.itheima.service.impl;

import com.itheima.domain.User;
import com.itheima.service.TestAfterThrowingService;
import com.itheima.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestAfterThrowingServiceImpl implements TestAfterThrowingService {

    @Autowired
    private TestService testService;

    @Override
    public void testAfterThrowing() {
        try{
            User user = new User();
            user.setUid(1);
            user.setPassword("123456");
            user.setUsername("Test");
            user.setTelephone("13147365762");
            testService.saveBach(user);
        }catch (Exception e){
            log.info("外层tryCache捕获到异常：{}",e.getMessage());
        }
    }
}
