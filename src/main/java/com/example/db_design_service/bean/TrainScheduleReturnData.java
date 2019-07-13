package com.example.db_design_service.bean;

import java.util.List;

public class TrainScheduleReturnData {
    private int status;
    private List<TrainScheduleInfo> trainScheduleInfoList;

    public int getStatus() {
        return status;
    }

    public TrainScheduleReturnData(int status, List<TrainScheduleInfo> trainScheduleInfoList) {
        this.status = status;
        this.trainScheduleInfoList = trainScheduleInfoList;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<TrainScheduleInfo> getTrainScheduleInfoList() {
        return trainScheduleInfoList;
    }

    public void setTrainScheduleInfoList(List<TrainScheduleInfo> trainScheduleInfoList) {
        this.trainScheduleInfoList = trainScheduleInfoList;
    }
}
