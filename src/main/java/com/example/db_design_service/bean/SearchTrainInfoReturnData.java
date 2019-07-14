package com.example.db_design_service.bean;

/**
 *
 * 作为查找 列车信息  的返回类
 * 如果查询到则返回对应的列车信息
 *
 */
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
