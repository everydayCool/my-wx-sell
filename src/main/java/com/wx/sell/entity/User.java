package com.wx.sell.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class User {

    /** 主键编号 */
    private Integer id;
    /** 用户名 */
    private String username;
    /** 密码 */
    private String password;

    private Timestamp createTime;

    private Timestamp updateTime;

    private Integer delFlag;

}



