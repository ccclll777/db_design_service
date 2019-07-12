package com.example.db_design_service.bean;

import java.util.List;

public class PassengerInfoReturnData {
    private int status;
    private List<PassengerInfo> passengerInfos;

    public PassengerInfoReturnData(int status, List<PassengerInfo> passengerInfos) {
        this.status = status;
        this.passengerInfos = passengerInfos;
    }

    public List<PassengerInfo> getPassengerInfos() {
        return passengerInfos;
    }

    public void setPassengerInfos(List<PassengerInfo> passengerInfos) {
        this.passengerInfos = passengerInfos;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
