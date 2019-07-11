package com.example.db_design_service.bean;

public class SearchTrainInfoReturnData {
    private  int status;
    private TrainInfo trainInfo;

    public TrainInfo getTrainInfo() {
        return trainInfo;
    }

    public SearchTrainInfoReturnData(int status, TrainInfo trainInfo) {
        this.status = status;
        this.trainInfo = trainInfo;
    }

    public void setTrainInfo(TrainInfo trainInfo) {
        this.trainInfo = trainInfo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
