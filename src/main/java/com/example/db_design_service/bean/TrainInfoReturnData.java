package com.example.db_design_service.bean;

import java.util.List;

/**
 *
 *
 * 对于列车信息 的返回
 * 对应前端的列车信息 列表
 * 会返回所有的列车信息
 */
public class TrainInfoReturnData {
    private int status;
    private List<TrainInfo> trainInfos;

    public TrainInfoReturnData(int status, List<TrainInfo> trainInfos) {
        this.status = status;
        this.trainInfos = trainInfos;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<TrainInfo> getTrainInfos() {
        return trainInfos;
    }

    public void setTrainInfos(List<TrainInfo> trainInfos) {
        this.trainInfos = trainInfos;
    }
}
