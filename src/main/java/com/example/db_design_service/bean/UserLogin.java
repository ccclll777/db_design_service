package com.example.db_design_service.bean;

/**
 *
 * 登陆注册 时
 * 数据库查询的返回结果
 * 用户查询用户是否注册
 * 是否重复注册过用户
 */
public class UserLogin {
    private String user_phone_number;
    private String user_password;

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_phone_number() {
        return user_phone_number;
    }

    public void setUser_phone_number(String user_phone_number) {
        this.user_phone_number = user_phone_number;
    }
}
