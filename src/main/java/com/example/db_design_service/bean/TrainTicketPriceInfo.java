package com.example.db_design_service.bean;

/**
 *
 * 车票查询类
 *
 * 可以根据起始站和终点站查询车票的价格
 *
 * 然后返回
 */
public class TrainTicketPriceInfo {
    private String train_no;
    private String train_number;
    private String start_station;
    private String end_station;
    private String start_no;
    private String end_no;
    private String start_time;
    private String arrive_time;
    private String start_running_time;
    private String end_running_time;
    private String high_seat_price;
    private String medium_seat_price;
    private String low_seat_price;

    public TrainTicketPriceInfo(String train_no, String train_number,
                                String start_station, String end_station, String start_no, String end_no,
                                String start_time, String arrive_time, String start_running_time, String end_running_time,
                                String high_seat_price, String medium_seat_price, String low_seat_price) {
        this.train_no = train_no;
        this.train_number = train_number;
        this.start_station = start_station;
        this.end_station = end_station;
        this.start_no = start_no;
        this.end_no = end_no;
        this.start_time = start_time;
        this.arrive_time = arrive_time;
        this.start_running_time = start_running_time;
        this.end_running_time = end_running_time;
        this.high_seat_price = high_seat_price;
        this.medium_seat_price = medium_seat_price;
        this.low_seat_price = low_seat_price;
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

    public String getStart_station() {
        return start_station;
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

    public String getHigh_seat_price() {
        return high_seat_price;
    }

    public void setHigh_seat_price(String high_seat_price) {
        this.high_seat_price = high_seat_price;
    }

    public String getMedium_seat_price() {
        return medium_seat_price;
    }

    public void setMedium_seat_price(String medium_seat_price) {
        this.medium_seat_price = medium_seat_price;
    }

    public String getLow_seat_price() {
        return low_seat_price;
    }

    public void setLow_seat_price(String low_seat_price) {
        this.low_seat_price = low_seat_price;
    }
}
