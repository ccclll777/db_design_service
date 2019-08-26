package com.example.db_design_service.bean;


/**
 *
 *
 * 列车信息类
 * 与数据库的train_info表相对应
 *
 */
public class TrainInfo {
    private String train_no;
    private String train_number;
    private String train_type;
    private String train_carriages;
    private String train_start_station;
    private String train_end_station;
    private String train_start_time;
    private String train_end_time;
    private String train_arrive_day;
    private String train_running_time;

    private String train_running_type;

    public TrainInfo(String train_no, String train_number, String train_type, String train_carriages, String train_start_station, String train_end_station, String train_start_time, String train_end_time, String train_arrive_day, String train_running_time, String train_running_type) {
        this.train_no = train_no;
        this.train_number = train_number;
        this.train_type = train_type;
        this.train_carriages = train_carriages;
        this.train_start_station = train_start_station;
        this.train_end_station = train_end_station;
        this.train_start_time = train_start_time;
        this.train_end_time = train_end_time;
        this.train_arrive_day = train_arrive_day;
        this.train_running_time = train_running_time;
        this.train_running_type = train_running_type;
    }

    public String getTrain_no() {
        return train_no;
    }

    public void setTrain_no(String train_no) {
        this.train_no = train_no;
    }

    public String getTrain_number() {
        return train_number;
    }

    public void setTrain_number(String train_number) {
        this.train_number = train_number;
    }

    public String getTrain_type() {
        return train_type;
    }

    public void setTrain_type(String train_type) {
        this.train_type = train_type;
    }

    public String getTrain_carriages() {
        return train_carriages;
    }

    public void setTrain_carriages(String train_carriages) {
        this.train_carriages = train_carriages;
    }

    public String getTrain_start_station() {
        return train_start_station;
    }

    public void setTrain_start_station(String train_start_station) {
        this.train_start_station = train_start_station;
    }

    public String getTrain_end_station() {
        return train_end_station;
    }

    public void setTrain_end_station(String train_end_station) {
        this.train_end_station = train_end_station;
    }

    public String getTrain_start_time() {
        return train_start_time;
    }

    public void setTrain_start_time(String train_start_time) {
        this.train_start_time = train_start_time;
    }

    public String getTrain_end_time() {
        return train_end_time;
    }

    public void setTrain_end_time(String train_end_time) {
        this.train_end_time = train_end_time;
    }

    public String getTrain_arrive_day() {
        return train_arrive_day;
    }

    public void setTrain_arrive_day(String train_arrive_day) {
        this.train_arrive_day = train_arrive_day;
    }

    public String getTrain_running_time() {
        return train_running_time;
    }

    public void setTrain_running_time(String train_running_time) {
        this.train_running_time = train_running_time;
    }

    public String getTrain_running_type() {
        return train_running_type;
    }

    public void setTrain_running_type(String train_running_type) {
        this.train_running_type = train_running_type;
    }
}
