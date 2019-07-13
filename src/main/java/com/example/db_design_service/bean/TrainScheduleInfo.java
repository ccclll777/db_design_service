package com.example.db_design_service.bean;

public class TrainScheduleInfo {
    private String train_number;
    private String start_station;
    private String end_station;
    private String start_no;
    private String end_no;
    private String start_time;
    private String arrive_time;
    private String start_running_time;
    private String end_running_time;

    public String getTrain_number() {
        return train_number;
    }

    public void setTrain_number(String train_number) {
        this.train_number = train_number;
    }

    public String getStart_station() {
        return start_station;
    }

    public TrainScheduleInfo(String train_number, String start_station, String end_station, String start_no, String end_no, String start_time, String arrive_time, String start_running_time, String end_running_time) {
        this.train_number = train_number;
        this.start_station = start_station;
        this.end_station = end_station;
        this.start_no = start_no;
        this.end_no = end_no;
        this.start_time = start_time;
        this.arrive_time = arrive_time;
        this.start_running_time = start_running_time;
        this.end_running_time = end_running_time;
    }

    public void setStart_station(String start_station) {

        this.start_station = start_station;
    }

    public String getEnd_station() {
        return end_station;
    }

    public void setEnd_station(String end_station) {
        this.end_station = end_station;
    }

    public String getStart_no() {
        return start_no;
    }

    public void setStart_no(String start_no) {
        this.start_no = start_no;
    }

    public String getEnd_no() {
        return end_no;
    }

    public void setEnd_no(String end_no) {
        this.end_no = end_no;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getArrive_time() {
        return arrive_time;
    }

    public void setArrive_time(String arrive_time) {
        this.arrive_time = arrive_time;
    }

    public String getStart_running_time() {
        return start_running_time;
    }

    public void setStart_running_time(String start_running_time) {
        this.start_running_time = start_running_time;
    }

    public String getEnd_running_time() {
        return end_running_time;
    }

    public void setEnd_running_time(String end_running_time) {
        this.end_running_time = end_running_time;
    }
}
