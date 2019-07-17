package com.example.db_design_service.bean;

import java.util.List;

public class GetOrderListReturnData {
    private int status;
    private List<GetOrderList> getOrderListList;

    public GetOrderListReturnData(int status, List<GetOrderList> getOrderListList) {
        this.status = status;
        this.getOrderListList = getOrderListList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<GetOrderList> getGetOrderListList() {
        return getOrderListList;
    }

    public void setGetOrderListList(List<GetOrderList> getOrderListList) {
        this.getOrderListList = getOrderListList;
    }
}
