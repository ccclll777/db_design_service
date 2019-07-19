package com.example.db_design_service.bean;

public class TrainTransferSeatCount {
    private String train_no;
    private String carriage_no;
    private String seat_type;
    private int seat_count;
    private String train_number;

    public TrainTransferSeatCount(String train_no, String carriage_no, String seat_type, int seat_count, String train_number) {
        this.train_no = train_no;
        this.carriage_no = carriage_no;
        this.seat_type = seat_type;
        this.seat_count = seat_count;
        this.train_number = train_number;
    }

    public void count()
    {
        seat_count--;
    }
    public String getTrain_no() {
        return train_no;
    }

    public void setTrain_no(String train_no) {
        this.train_no = train_no;
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

    public int getSeat_count() {
        return seat_count;
    }

    public void setSeat_count(int seat_count) {
        this.seat_count = seat_count;
    }

    public String getTrain_number() {
        return train_number;
    }

    public void setTrain_number(String train_number) {
        this.train_number = train_number;
    }
}
