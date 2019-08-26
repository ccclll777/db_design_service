package com.example.db_design_service.bean;

import java.util.List;

public class GetAllOrderReturnData {
    private int status;
    private List<AllOrder> allOrderList;

    public GetAllOrderReturnData()
    {

    }
    public GetAllOrderReturnData(int status, List<AllOrder> allOrderList) {
        this.status = status;
        this.allOrderList = allOrderList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<AllOrder> getAllOrderList() {
        return allOrderList;
    }

    public void setAllOrderList(List<AllOrder> allOrderList) {
        this.allOrderList = allOrderList;
    }
}
