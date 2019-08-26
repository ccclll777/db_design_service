package com.example.db_design_service.bean;

import java.util.List;

public class GetAllUserReturnData {

    private int status;
    private List<User> userList;

    public GetAllUserReturnData()
    {

    }
    public GetAllUserReturnData(int status, List<User> userList) {
        this.status = status;
        this.userList = userList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
