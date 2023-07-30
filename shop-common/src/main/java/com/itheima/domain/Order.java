package com.itheima.domain;

import lombok.Data;

/**
 * 订单
 */
@Data
public class Order {

    private Long oid;  //订单id

    //用户
    private Integer uid; //用户id

    private String username; //用户名

    //商品相关
    private Integer pid; //商品id

    private String pname; //商品名称

    private Double pprece; //商品单价

    private Integer number; //购买数量

}
