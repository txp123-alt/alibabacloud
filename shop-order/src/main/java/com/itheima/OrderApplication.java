package com.itheima;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan("com.itheima.mapper")
public class OrderApplication {
    public static void main(String[] args){
        SpringApplication.run(OrderApplication.class);
    }

    //声明一个Http请求工具 RestTemplate
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
