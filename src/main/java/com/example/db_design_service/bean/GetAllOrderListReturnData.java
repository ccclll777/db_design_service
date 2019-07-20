package com.example.db_design_service.bean;

import java.util.List;

public class GetAllOrderListReturnData {
    private int status;
    private List<GetAllOrderList> getAllOrderListList;

    public GetAllOrderListReturnData(int status, List<GetAllOrderList> getAllOrderListList) {
        this.status = status;
        this.getAllOrderListList = getAllOrderListList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<GetAllOrderList> getGetAllOrderListList() {
        return getAllOrderListList;
    }

    public void setGetAllOrderListList(List<GetAllOrderList> getAllOrderListList) {
        this.getAllOrderListList = getAllOrderListList;
    }
}
