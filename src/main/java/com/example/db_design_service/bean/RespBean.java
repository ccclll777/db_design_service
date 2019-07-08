package com.example.db_design_service.bean;

public class RespBean {
    private int code;
    private Token data;



    public RespBean(int code, Token data) {

        this.code = code;
        this.data  =data;

    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public Token getData() {
        return data;
    }

    public void setData(Token data) {
        this.data = data;
    }

}
