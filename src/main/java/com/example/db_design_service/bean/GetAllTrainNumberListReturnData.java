package com.example.db_design_service.bean;

import java.util.List;

public class GetAllTrainNumberListReturnData {
    private int status;
    private List<TrainNumberData>  DataLists;

    public GetAllTrainNumberListReturnData(int status, List<TrainNumberData> dataLists) {
        this.status = status;
        DataLists = dataLists;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<TrainNumberData> getDataLists() {
        return DataLists;
    }

    public void setDataLists(List<TrainNumberData> dataLists) {
        DataLists = dataLists;
    }
}
