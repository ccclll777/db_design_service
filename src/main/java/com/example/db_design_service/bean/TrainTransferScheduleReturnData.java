package com.example.db_design_service.bean;

import java.util.List;

public class TrainTransferScheduleReturnData {
    private int status;
    private List<TrainTransferSchedule> trainTransferScheduleList;

    public TrainTransferScheduleReturnData(int status, List<TrainTransferSchedule> trainTransferScheduleList) {
        this.status = status;
        this.trainTransferScheduleList = trainTransferScheduleList;
    }

    public int getStatus() {

        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<TrainTransferSchedule> getTrainTransferScheduleList() {
        return trainTransferScheduleList;
    }

    public void setTrainTransferScheduleList(List<TrainTransferSchedule> trainTransferScheduleList) {
        this.trainTransferScheduleList = trainTransferScheduleList;
    }
}
