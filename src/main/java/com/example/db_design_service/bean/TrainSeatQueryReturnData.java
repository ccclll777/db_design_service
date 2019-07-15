package com.example.db_design_service.bean;

import java.util.List;

/**
 *
 * 作为余座数量的返回值
 */
public class TrainSeatQueryReturnData {
    private int status;
    private List<TrainRemainingSeats> trainRemainingSeats;
    private List<TrainRemainingSeats_GD> trainRemainingSeats_gds;

    public TrainSeatQueryReturnData(int status, List<TrainRemainingSeats> trainRemainingSeats, List<TrainRemainingSeats_GD> trainRemainingSeats_gds) {
        this.status = status;
        this.trainRemainingSeats = trainRemainingSeats;
        this.trainRemainingSeats_gds = trainRemainingSeats_gds;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<TrainRemainingSeats> getTrainRemainingSeats() {
        return trainRemainingSeats;
    }

    public void setTrainRemainingSeats(List<TrainRemainingSeats> trainRemainingSeats) {
        this.trainRemainingSeats = trainRemainingSeats;
    }

    public List<TrainRemainingSeats_GD> getTrainRemainingSeats_gds() {
        return trainRemainingSeats_gds;
    }

    public void setTrainRemainingSeats_gds(List<TrainRemainingSeats_GD> trainRemainingSeats_gds) {
        this.trainRemainingSeats_gds = trainRemainingSeats_gds;
    }
}

