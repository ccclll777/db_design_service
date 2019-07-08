package com.example.db_design_service.bean;

public class UserInfo {
    private int code;
    private Data data;
    public UserInfo(int code,Data data)
    {
        this.code = code;
        this.data = data;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
