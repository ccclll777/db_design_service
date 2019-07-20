package com.example.db_design_service.bean;

public class GetAllOrderList {
    private String order_id;
    private String passenger_real_name;
    private String train_number;
    private String start_station_name;
    private String end_station_name;
    private String carriage_no;
    private String seat_type;
    private String seat_no;
    private String start_date;
    private String start_time;
    private String order_status;
    private String passenger_phone_number;
    private String passenger_id_number;
    private String order_money;

    public GetAllOrderList(String order_id, String passenger_real_name, String train_number, String start_station_name, String end_station_name, String carriage_no, String seat_type, String seat_no, String start_date, String start_time, String order_status, String passenger_phone_number, String passenger_id_number, String order_money) {
        this.order_id = order_id;
        this.passenger_real_name = passenger_real_name;
        this.train_number = train_number;
        this.start_station_name = start_station_name;
        this.end_station_name = end_station_name;
        this.carriage_no = carriage_no;
        this.seat_type = seat_type;
        this.seat_no = seat_no;
        this.start_date = start_date;
        this.start_time = start_time;
        this.order_status = order_status;
        this.passenger_phone_number = passenger_phone_number;
        this.passenger_id_number = passenger_id_number;
        this.order_money = order_money;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getPassenger_real_name() {
        return passenger_real_name;
    }

    public void setPassenger_real_name(String passenger_real_name) {
        this.passenger_real_name = passenger_real_name;
    }

    public String getTrain_number() {
        return train_number;
    }

    public void setTrain_number(String train_number) {
        this.train_number = train_number;
    }

    public String getStart_station_name() {
        return start_station_name;
    }

    public void setStart_station_name(String start_station_name) {
        this.start_station_name = start_station_name;
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

    public String getSeat_type() {
        return seat_type;
    }

    public void setSeat_type(String seat_type) {
        this.seat_type = seat_type;
    }

    public String getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(String seat_no) {
        this.seat_no = seat_no;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
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

    public String getOrder_money() {
        return order_money;
    }

    public void setOrder_money(String order_money) {
        this.order_money = order_money;
    }
}
