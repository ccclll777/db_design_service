package com.example.db_design_service.bean;

import java.util.List;

public class TrainTransferTicketPriceReturnData {

    private int status;
    private List<TrainTransferTicketPriceInfo> trainTransferTicketPriceInfoList;

    public TrainTransferTicketPriceReturnData(int status, List<TrainTransferTicketPriceInfo> trainTransferTicketPriceInfoList) {
        this.status = status;
        this.trainTransferTicketPriceInfoList = trainTransferTicketPriceInfoList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<TrainTransferTicketPriceInfo> getTrainTransferTicketPriceInfoList() {
        return trainTransferTicketPriceInfoList;
    }

    public void setTrainTransferTicketPriceInfoList(List<TrainTransferTicketPriceInfo> trainTransferTicketPriceInfoList) {
        this.trainTransferTicketPriceInfoList = trainTransferTicketPriceInfoList;
    }
}
