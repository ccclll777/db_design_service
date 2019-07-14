package com.example.db_design_service.bean;

import java.util.List;

/**
 *
 *列车时刻信息的返回，对应前端的列车时刻表类
 *
 * 可以查询列车经停的所有站
 */
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
