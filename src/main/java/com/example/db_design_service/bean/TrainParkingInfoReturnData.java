package com.example.db_design_service.bean;

import java.util.List;

public class TrainParkingInfoReturnData {

    private int status;
    private List<TrainParkingInfo> trainParkingInfo;


    public TrainParkingInfoReturnData(int status, List<TrainParkingInfo> trainParkingInfo) {
        this.status = status;
        this.trainParkingInfo = trainParkingInfo;
    }

    public int getStatus() {
        return status;

    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<TrainParkingInfo> getTrainParkingInfo() {
        return trainParkingInfo;
    }

    public void setTrainParkingInfo(List<TrainParkingInfo> trainParkingInfo) {
        this.trainParkingInfo = trainParkingInfo;
    }
}
