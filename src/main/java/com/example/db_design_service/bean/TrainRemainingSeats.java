package com.example.db_design_service.bean;

/**
 *
 *
 * 其他列车yu余座的统计量
 * */
public class TrainRemainingSeats {
    private String carriage_no;
    private String seat_type;
    private int High_seat_upper = 18;
    private int High_seat_lower = 18;
    private int Medium_seat_upper = 22;
    private   int Medium_seat_middle = 22;
    private   int Medium_seat_lower = 22;
    private   int Low_seat_A = 20;
    private   int Low_seat_B = 20;
    private   int Low_seat_C = 20;
    private   int Low_seat_D = 20;
    private   int Low_seat_E = 20;
    private   int Low_seat_F = 20;

    public TrainRemainingSeats(String carriage_no, String seat_type) {
        this.carriage_no = carriage_no;
        this.seat_type = seat_type;
    }
    public void Count(int seat_no)
    {
            if(this.getSeat_type().equals("软卧"))
            {
                if(seat_no%2 == 0)
                {
                        High_seat_upper --;
                }
                if(seat_no%2 == 1)
                {
                        High_seat_lower --;
                }
            }
        if(this.getSeat_type().equals("硬卧"))
        {
            if(seat_no%3 == 0)
            {
               Medium_seat_upper --;
            }
            if(seat_no%3 == 1)
            {
               Medium_seat_middle --;
            }
            if(seat_no%3 == 2)
            {
               Medium_seat_lower -- ;
            }
        }
        if(this.getSeat_type().equals("硬坐"))
        {
            if(seat_no%6 == 0)
            {
                Low_seat_A --;
            }
            if(seat_no%6 == 1)
            {
                Low_seat_B --;
            }
            if(seat_no%6 == 2)
            {
                Low_seat_C --;
            }
            if(seat_no%6 == 3)
            {
                Low_seat_D --;
            }
            if(seat_no%6 == 4)
            {
                Low_seat_E --;
            }
            if(seat_no%6 == 5)
            {
                Low_seat_F --;
            }

        }

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

    public int getHigh_seat_upper() {
        return High_seat_upper;
    }

    public void setHigh_seat_upper(int high_seat_upper) {
        High_seat_upper = high_seat_upper;
    }

    public int getHigh_seat_lower() {
        return High_seat_lower;
    }

    public void setHigh_seat_lower(int high_seat_lower) {
        High_seat_lower = high_seat_lower;
    }

    public int getMedium_seat_upper() {
        return Medium_seat_upper;
    }

    public void setMedium_seat_upper(int medium_seat_upper) {
        Medium_seat_upper = medium_seat_upper;
    }

    public int getMedium_seat_middle() {
        return Medium_seat_middle;
    }

    public void setMedium_seat_middle(int medium_seat_middle) {
        Medium_seat_middle = medium_seat_middle;
    }

    public int getMedium_seat_lower() {
        return Medium_seat_lower;
    }

    public void setMedium_seat_lower(int medium_seat_lower) {
        Medium_seat_lower = medium_seat_lower;
    }


    public int getLow_seat_A() {
        return Low_seat_A;
    }

    public void setLow_seat_A(int low_seat_A) {
        Low_seat_A = low_seat_A;
    }

    public int getLow_seat_B() {
        return Low_seat_B;
    }

    public void setLow_seat_B(int low_seat_B) {
        Low_seat_B = low_seat_B;
    }

    public int getLow_seat_C() {
        return Low_seat_C;
    }

    public void setLow_seat_C(int low_seat_C) {
        Low_seat_C = low_seat_C;
    }

    public int getLow_seat_D() {
        return Low_seat_D;
    }

    public void setLow_seat_D(int low_seat_D) {
        Low_seat_D = low_seat_D;
    }

    public int getLow_seat_E() {
        return Low_seat_E;
    }

    public void setLow_seat_E(int low_seat_E) {
        Low_seat_E = low_seat_E;
    }

    public int getLow_seat_F() {
        return Low_seat_F;
    }

    public void setLow_seat_F(int low_seat_F) {
        Low_seat_F = low_seat_F;
    }
}
