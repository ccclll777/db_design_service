package com.example.db_design_service.bean;

import java.util.List;

/**
 *
 * 作为查询票价的返回值
 */
public class TrainTicketPriceQueryReturnData {

    private int status;
    private List<TrainTicketPriceInfo> trainTicketPriceInfoList;


    public List<TrainTicketPriceInfo> getTrainTicketPriceInfoList() {
        return trainTicketPriceInfoList;
    }

    public TrainTicketPriceQueryReturnData(int status, List<TrainTicketPriceInfo> trainTicketPriceInfoList) {
        this.status = status;
        this.trainTicketPriceInfoList = trainTicketPriceInfoList;
    }

    public void setTrainTicketPriceInfoList(List<TrainTicketPriceInfo> trainTicketPriceInfoList) {
        this.trainTicketPriceInfoList = trainTicketPriceInfoList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
