package com.example.db_design_service.bean;

import java.util.List;

public class TrainTransferSeatCountReturnData {
    private  int status;
    private List<TrainTransferSeatCount> trainTransferSeatCountList;

    public TrainTransferSeatCountReturnData(int status, List<TrainTransferSeatCount> trainTransferSeatCountList) {
        this.status = status;
        this.trainTransferSeatCountList = trainTransferSeatCountList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<TrainTransferSeatCount> getTrainTransferSeatCountList() {
        return trainTransferSeatCountList;
    }

    public void setTrainTransferSeatCountList(List<TrainTransferSeatCount> trainTransferSeatCountList) {
        this.trainTransferSeatCountList = trainTransferSeatCountList;
    }
}
