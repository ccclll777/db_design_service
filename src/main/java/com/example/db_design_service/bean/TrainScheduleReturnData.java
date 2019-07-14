package com.example.db_design_service.bean;

import java.util.List;

/**
 *
 *
 * 列车查询的返回类，查询到符合要求的列车信息
 *
 * 对应前端的列车查询
 */
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
