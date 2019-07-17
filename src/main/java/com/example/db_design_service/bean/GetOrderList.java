package com.example.db_design_service.bean;

public class GetOrderList {
    private String order_id;
    private String passenger_real_name;
    private String passenger_phone_number;
    private String passenger_id_number;
    private String carriage_no;
    private String seat_type;
    private String seat_no;

    public GetOrderList(String order_id, String passenger_real_name, String passenger_phone_number, String passenger_id_number, String carriage_no, String seat_type, String seat_no) {
        this.order_id = order_id;
        this.passenger_real_name = passenger_real_name;
        this.passenger_phone_number = passenger_phone_number;
        this.passenger_id_number = passenger_id_number;
        this.carriage_no = carriage_no;
        this.seat_type = seat_type;
        this.seat_no = seat_no;
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
}
