package com.example.db_design_service.bean;

/**
 *
 *
 *
 * 查询  列车换乘的车票价格信息
 */
public class TrainTransferTicketPriceInfo {
    private String train_no_1;
    private String train_number_1;
    private String train_no_2;
    private String train_number_2;
    private String start_station_no;
    private String start_station_name;
    private String transfer_station_no_1;
    private String transfer_station_name;
    private String start_time_1;
    private String arrive_time_1;
    private String start_time_2;
    private String arrive_time_2;
    private String end_station_no;
    private String end_station_name;
    private String start_running_time_1;
    private String end_running_time_1;
    private String start_running_time_2;
    private String end_running_time_2;
    private String transfer_station_no_2;

    private String high_seat_price_1;
    private String medium_seat_price_1;
    private String low_seat_price_1;
    private String high_seat_price_2;
    private String medium_seat_price_2;
    private String low_seat_price_2;

    public TrainTransferTicketPriceInfo(String train_no_1, String train_number_1, String train_no_2, String train_number_2, String start_station_no, String start_station_name, String transfer_station_no_1, String transfer_station_name, String start_time_1, String arrive_time_1, String start_time_2, String arrive_time_2, String end_station_no, String end_station_name, String start_running_time_1, String end_running_time_1, String start_running_time_2, String end_running_time_2, String transfer_station_no_2, String high_seat_price_1, String medium_seat_price_1, String low_seat_price_1, String high_seat_price_2, String medium_seat_price_2, String low_seat_price_2) {
        this.train_no_1 = train_no_1;
        this.train_number_1 = train_number_1;
        this.train_no_2 = train_no_2;
        this.train_number_2 = train_number_2;
        this.start_station_no = start_station_no;
        this.start_station_name = start_station_name;
        this.transfer_station_no_1 = transfer_station_no_1;
        this.transfer_station_name = transfer_station_name;
        this.start_time_1 = start_time_1;
        this.arrive_time_1 = arrive_time_1;
        this.start_time_2 = start_time_2;
        this.arrive_time_2 = arrive_time_2;
        this.end_station_no = end_station_no;
        this.end_station_name = end_station_name;
        this.start_running_time_1 = start_running_time_1;
        this.end_running_time_1 = end_running_time_1;
        this.start_running_time_2 = start_running_time_2;
        this.end_running_time_2 = end_running_time_2;
        this.transfer_station_no_2 = transfer_station_no_2;
        this.high_seat_price_1 = high_seat_price_1;
        this.medium_seat_price_1 = medium_seat_price_1;
        this.low_seat_price_1 = low_seat_price_1;
        this.high_seat_price_2 = high_seat_price_2;
        this.medium_seat_price_2 = medium_seat_price_2;
        this.low_seat_price_2 = low_seat_price_2;
    }

    public String getTrain_no_1() {
        return train_no_1;
    }

    public void setTrain_no_1(String train_no_1) {
        this.train_no_1 = train_no_1;
    }

    public String getTrain_number_1() {
        return train_number_1;
    }

    public void setTrain_number_1(String train_number_1) {
        this.train_number_1 = train_number_1;
    }

    public String getTrain_no_2() {
        return train_no_2;
    }

    public void setTrain_no_2(String train_no_2) {
        this.train_no_2 = train_no_2;
    }

    public String getTrain_number_2() {
        return train_number_2;
    }

    public void setTrain_number_2(String train_number_2) {
        this.train_number_2 = train_number_2;
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

    public String getTransfer_station_no_1() {
        return transfer_station_no_1;
    }

    public void setTransfer_station_no_1(String transfer_station_no_1) {
        this.transfer_station_no_1 = transfer_station_no_1;
    }

    public String getTransfer_station_name() {
        return transfer_station_name;
    }

    public void setTransfer_station_name(String transfer_station_name) {
        this.transfer_station_name = transfer_station_name;
    }

    public String getStart_time_1() {
        return start_time_1;
    }

    public void setStart_time_1(String start_time_1) {
        this.start_time_1 = start_time_1;
    }

    public String getArrive_time_1() {
        return arrive_time_1;
    }

    public void setArrive_time_1(String arrive_time_1) {
        this.arrive_time_1 = arrive_time_1;
    }

    public String getStart_time_2() {
        return start_time_2;
    }

    public void setStart_time_2(String start_time_2) {
        this.start_time_2 = start_time_2;
    }

    public String getEnd_station_no() {
        return end_station_no;
    }

    public void setEnd_station_no(String end_station_no) {
        this.end_station_no = end_station_no;
    }

    public String getArrive_time_2() {
        return arrive_time_2;
    }

    public void setArrive_time_2(String arrive_time_2) {
        this.arrive_time_2 = arrive_time_2;
    }

    public String getEnd_station_name() {
        return end_station_name;
    }

    public void setEnd_station_name(String end_station_name) {
        this.end_station_name = end_station_name;
    }

    public String getStart_running_time_1() {
        return start_running_time_1;
    }

    public void setStart_running_time_1(String start_running_time_1) {
        this.start_running_time_1 = start_running_time_1;
    }

    public String getEnd_running_time_1() {
        return end_running_time_1;
    }

    public void setEnd_running_time_1(String end_running_time_1) {
        this.end_running_time_1 = end_running_time_1;
    }

    public String getStart_running_time_2() {
        return start_running_time_2;
    }

    public void setStart_running_time_2(String start_running_time_2) {
        this.start_running_time_2 = start_running_time_2;
    }

    public String getEnd_running_time_2() {
        return end_running_time_2;
    }

    public void setEnd_running_time_2(String end_running_time_2) {
        this.end_running_time_2 = end_running_time_2;
    }

    public String getTransfer_station_no_2() {
        return transfer_station_no_2;
    }

    public void setTransfer_station_no_2(String transfer_station_no_2) {
        this.transfer_station_no_2 = transfer_station_no_2;
    }


    public String getHigh_seat_price_1() {
        return high_seat_price_1;
    }

    public void setHigh_seat_price_1(String high_seat_price_1) {
        this.high_seat_price_1 = high_seat_price_1;
    }

    public String getMedium_seat_price_1() {
        return medium_seat_price_1;
    }

    public void setMedium_seat_price_1(String medium_seat_price_1) {
        this.medium_seat_price_1 = medium_seat_price_1;
    }

    public String getLow_seat_price_1() {
        return low_seat_price_1;
    }

    public void setLow_seat_price_1(String low_seat_price_1) {
        this.low_seat_price_1 = low_seat_price_1;
    }

    public String getHigh_seat_price_2() {
        return high_seat_price_2;
    }

    public void setHigh_seat_price_2(String high_seat_price_2) {
        this.high_seat_price_2 = high_seat_price_2;
    }

    public String getMedium_seat_price_2() {
        return medium_seat_price_2;
    }

    public void setMedium_seat_price_2(String medium_seat_price_2) {
        this.medium_seat_price_2 = medium_seat_price_2;
    }

    public String getLow_seat_price_2() {
        return low_seat_price_2;
    }

    public void setLow_seat_price_2(String low_seat_price_2) {
        this.low_seat_price_2 = low_seat_price_2;
    }
}
