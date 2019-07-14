package com.example.db_design_service.bean;
/**
 *
 *
 * 作为查询用户信息查询的返回
 *
 *
 */
public class UserInfoReturnData {

   private int status;
   private UserInfo data;

    public UserInfoReturnData(int status, UserInfo data) {
        this.status = status;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserInfo getData() {
        return data;
    }

    public void setData(UserInfo data) {
        this.data = data;
    }
}
