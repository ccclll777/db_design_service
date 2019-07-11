package com.example.db_design_service.bean;

public class RespBean {
    private int status;
    private String success;



    public RespBean(int status, String success) {

        this.status = status;
        this.success  =success;

    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
