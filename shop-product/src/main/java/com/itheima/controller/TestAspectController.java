package com.itheima.controller;

import com.itheima.service.TestAfterThrowingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestAspectController {

    @Autowired
    private TestAfterThrowingService testAfterThrowingService;

    @RequestMapping("/test/afterThrowing")
    public void testAfterThrowing(){
        log.info("请求测试方法");
        testAfterThrowingService.testAfterThrowing();
    }
}
