package com.itheima.aspect;

import com.alibaba.fastjson.JSON;
import com.itheima.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TransactionAspect {

    @Autowired
    private ProductService productService;

    @Around(value = "@annotation(DscTransaction)")
    public void AroundAspect(ProceedingJoinPoint joinPoint){
        String methodName = "";
        try{
            //首先拿到参数
            Object[] args = joinPoint.getArgs();
            methodName = joinPoint.getSignature().getName();
            log.info("目标方法名为：{}",methodName);
            log.info("获取到的方法参数为：{}",JSON.toJSONString(args));
            joinPoint.proceed();
            log.info("目标方法执行完成");
        }catch (Throwable e){
            e.printStackTrace();
            log.info("方法发生异常：{}",e.getMessage());
            String name = joinPoint.getTarget().getClass().getName();
            log.info("目标方法所在类名为：{}",name);
            throw new RuntimeException(e.getMessage());
        }
    }
}
