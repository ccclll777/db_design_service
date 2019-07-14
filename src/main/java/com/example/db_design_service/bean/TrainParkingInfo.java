package com.example.db_design_service.bean;

/**
 *
 *
 * 列车时刻表类  数据库的train_parking_info表
 * 存储列车的时刻信息
 *
 */
public class TrainParkingInfo {

    private String train_number;
    private String arrive_day_str;
    private String start_time;
    private String arrive_time;
    private String running_time;
    private String station_no;
    private String station_name;

    public TrainParkingInfo( String station_no, String station_name,String train_number, String start_time, String arrive_time, String running_time,String arrive_day_str) {
        this.train_number = train_number;
        this.arrive_day_str = arrive_day_str;
        this.start_time = start_time;
        this.arrive_time = arrive_time;
        this.running_time = running_time;
        this.station_no = station_no;
        this.station_name = station_name;
    }



    public String getTrain_number() {
        return train_number;
    }

    public void setTrain_number(String train_number) {
        this.train_number = train_number;
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

    public String getRunning_time() {
        return running_time;
    }

    public void setRunning_time(String running_time) {
        this.running_time = running_time;
    }

    public String getStation_no() {
        return station_no;
    }

    public void setStation_no(String station_no) {
        this.station_no = station_no;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public String getArrive_day_str() {
        return arrive_day_str;
    }

    public void setArrive_day_str(String arrive_day_str) {
        this.arrive_day_str = arrive_day_str;
    }


}
