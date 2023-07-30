package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 订单
 */
@Data
@TableName("t_order")
public class Order {

    @TableId(value = "oid",type = IdType.AUTO)
    private Long oid;  //订单id

    //用户
    @TableField("user_id")
    private Integer uid;

    //用户名
    @TableField("user_name")
    private String username;

    //商品相关
    @TableField("pid")
    private Integer pid;

    //商品名称
    @TableField("p_name")
    private String pname;

    //商品单价
    @TableField("p_prece")
    private Double pprece;

    //购买数量
    @TableField("number")
    private Integer number;

}
