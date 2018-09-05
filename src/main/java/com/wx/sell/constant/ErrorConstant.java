package com.wx.sell.constant;

/**
 * Created by inner_peace
 */
public interface ErrorConstant {

    interface Order {

    }

    interface Goods {


    }


    interface Auth {
        static final String USERNAME_PASSWORD_IS_EMPTY = "用户名和密码不可为空";
        static final String USERNAME_PASSWORD_ERROR = "用户名不存在或密码错误";
        static final String NOT_LOGIN = "用户未登录";
    }



}
