package com.example.db_design_service.bean;
/**
 *
 * 作为  列车作为信息的返回类  根据车厢返回列车的  座位数和座位类型
 */
public class TrainSeatCount {
    private String carriage_no;
    private String seat_type;
    private int seat_count;

    public TrainSeatCount(String carriage_no, String seat_type, int seat_count) {
        this.carriage_no = carriage_no;
        this.seat_type = seat_type;
        this.seat_count = seat_count;
    }

    public int getSeat_count() {
        return seat_count;
    }

    public void setSeat_count(int seat_count) {
        this.seat_count = seat_count;
    }

    public String getSeat_type() {
        return seat_type;
    }

    public void setSeat_type(String seat_type) {
        this.seat_type = seat_type;
    }

    public String getCarriage_no() {
        return carriage_no;
    }

    public void setCarriage_no(String carriage_no) {
        this.carriage_no = carriage_no;
    }
}
