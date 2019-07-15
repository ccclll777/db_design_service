package com.example.db_design_service.bean;

/**
 *
 * 作为  以及被预定座位的返回类
 */
public class TrainSeatQuery {
    private String train_no;
    private String carriage_no;
    private String seat_no;

    public String getSeat_no() {
        return seat_no;
    }

    public TrainSeatQuery(String train_no, String carriage_no, String seat_no) {
        this.train_no = train_no;
        this.carriage_no = carriage_no;
        this.seat_no = seat_no;
    }

    public void setSeat_no(String seat_no) {
        this.seat_no = seat_no;
    }

    public String getCarriage_no() {
        return carriage_no;
    }

    public void setCarriage_no(String carriage_no) {
        this.carriage_no = carriage_no;
    }

    public String getTrain_no() {
        return train_no;
    }

    public void setTrain_no(String train_no) {
        this.train_no = train_no;
    }
}
