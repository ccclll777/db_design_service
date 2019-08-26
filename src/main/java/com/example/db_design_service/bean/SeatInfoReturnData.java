package com.example.db_design_service.bean;

import java.util.List;

public class SeatInfoReturnData {
    private int status;
    private List<SeatInfo> seatInfoList;

    public SeatInfoReturnData(int status, List<SeatInfo> seatInfoList) {
        this.status = status;
        this.seatInfoList = seatInfoList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<SeatInfo> getSeatInfoList() {
        return seatInfoList;
    }

    public void setSeatInfoList(List<SeatInfo> seatInfoList) {
        this.seatInfoList = seatInfoList;
    }
}
