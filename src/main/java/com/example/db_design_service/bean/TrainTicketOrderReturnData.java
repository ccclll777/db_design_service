package com.example.db_design_service.bean;

public class TrainTicketOrderReturnData {
    private int status;
    private String carriage_no;
    private String seat_type;
    private String result_seat_no;
    private String passenger_phone_number;

    public TrainTicketOrderReturnData(int status, String carriage_no, String seat_type, String result_seat_no, String passenger_phone_number) {
        this.status = status;
        this.carriage_no = carriage_no;
        this.seat_type = seat_type;
        this.result_seat_no = result_seat_no;
        this.passenger_phone_number = passenger_phone_number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getResult_seat_no() {
        return result_seat_no;
    }

    public void setResult_seat_no(String result_seat_no) {
        this.result_seat_no = result_seat_no;
    }

    public String getPassenger_phone_number() {
        return passenger_phone_number;
    }

    public void setPassenger_phone_number(String passenger_phone_number) {
        this.passenger_phone_number = passenger_phone_number;
    }
}
