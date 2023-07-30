package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class User {

    @TableId(value = "uid",type = IdType.AUTO)
    private Integer uid;

    @TableField("user_name")
    private String username;

    @TableField("pass_word")
    private String password;

    @TableField("tele_phone")
    private String telephone;
}
