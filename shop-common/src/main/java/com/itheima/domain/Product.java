package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_product")
public class Product {

    @TableId(value = "pid",type = IdType.AUTO)
    private Integer pid;

    @TableField("p_name")
    private String pname;

    @TableField("p_price")
    private Double pprice;

    @TableField("p_stock")
    private Integer stock;
}
