package com.example.db_design_service.bean;

public class GetAllNoTripData {

    private String order_id;
    private String train_no;
    private String start_station_no;
    public GetAllNoTripData(String order_id, String train_no, String start_station_no) {
        this.order_id = order_id;
        this.train_no = train_no;
        this.start_station_no = start_station_no;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getTrain_no() {
        return train_no;
    }

    public void setTrain_no(String train_no) {
        this.train_no = train_no;
    }

    public String getStart_station_no() {
        return start_station_no;
    }

    public void setStart_station_no(String start_station_no) {
        this.start_station_no = start_station_no;
    }
}
