package com.example.db_design_service.bean;


/**
 * 订单信息
 *
 * 对应订单表
 */
public class OrderList {

    private String user_phone_number;
    private String passenger_phone_number;
    private String passenger_id_number;
    private String train_no;
    private String start_station_no;
    private String start_station_name;
    private String end_station_no;
    private String end_station_name;
    private String carriage_no;
    private String seat_no;
    private String order_money;
    private String order_create_time;
    private String order_status;
    private String train_start_date;

    public OrderList(String user_phone_number, String passenger_phone_number, String passenger_id_number, String train_no, String start_station_no, String start_station_name, String end_station_no, String end_station_name, String carriage_no, String seat_no, String order_money, String order_create_time, String order_status, String train_start_date) {
        this.user_phone_number = user_phone_number;
        this.passenger_phone_number = passenger_phone_number;
        this.passenger_id_number = passenger_id_number;
        this.train_no = train_no;
        this.start_station_no = start_station_no;
        this.start_station_name = start_station_name;
        this.end_station_no = end_station_no;
        this.end_station_name = end_station_name;
        this.carriage_no = carriage_no;
        this.seat_no = seat_no;
        this.order_money = order_money;
        this.order_create_time = order_create_time;
        this.order_status = order_status;
        this.train_start_date = train_start_date;
    }

    public String getUser_phone_number() {
        return user_phone_number;
    }

    public void setUser_phone_number(String user_phone_number) {
        this.user_phone_number = user_phone_number;
    }

    public String getPassenger_phone_number() {
        return passenger_phone_number;
    }

    public void setPassenger_phone_number(String passenger_phone_number) {
        this.passenger_phone_number = passenger_phone_number;
    }

    public String getPassenger_id_number() {
        return passenger_id_number;
    }

    public void setPassenger_id_number(String passenger_id_number) {
        this.passenger_id_number = passenger_id_number;
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

    public String getStart_station_name() {
        return start_station_name;
    }

    public void setStart_station_name(String start_station_name) {
        this.start_station_name = start_station_name;
    }

    public String getEnd_station_no() {
        return end_station_no;
    }

    public void setEnd_station_no(String end_station_no) {
        this.end_station_no = end_station_no;
    }

    public String getEnd_station_name() {
        return end_station_name;
    }

    public void setEnd_station_name(String end_station_name) {
        this.end_station_name = end_station_name;
    }

    public String getCarriage_no() {
        return carriage_no;
    }

    public void setCarriage_no(String carriage_no) {
        this.carriage_no = carriage_no;
    }

    public String getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(String seat_no) {
        this.seat_no = seat_no;
    }

    public String getOrder_money() {
        return order_money;
    }

    public void setOrder_money(String order_money) {
        this.order_money = order_money;
    }

    public String getOrder_create_time() {
        return order_create_time;
    }

    public void setOrder_create_time(String order_create_time) {
        this.order_create_time = order_create_time;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getTrain_start_date() {
        return train_start_date;
    }

    public void setTrain_start_date(String train_start_date) {
        this.train_start_date = train_start_date;
    }
}
