package com.example.db_design_service.bean;

/**
 *
 *
 * 高铁动车 余座的统计量
 */
public class TrainRemainingSeats_GD {
    private String carriage_no;
    private String seat_type;
   private int High_seat_GD_A = 6;
    private int High_seat_GD_B = 6;
  private   int High_seat_GD_C = 6;
   private int Medium_seat_GD_A = 13;
    private   int Medium_seat_GD_B = 13;
    private   int Medium_seat_GD_C = 13;
    private   int Medium_seat_GD_D = 13;
    private   int Low_seat_GD_A = 17;
    private   int Low_seat_GD_B = 17;
    private   int Low_seat_GD_C = 17;
    private   int Low_seat_GD_D = 17;
    private   int Low_seat_GD_E = 17;


    public TrainRemainingSeats_GD(String carriage_no, String seat_type) {
        this.carriage_no = carriage_no;
        this.seat_type = seat_type;
    }

    public void Count(int seat_no)
    {
        if(this.getSeat_type().equals("特等座"))
        {
            if(seat_no%3 == 0)
            {
                High_seat_GD_A --;
            }
            if(seat_no%3 == 1)
            {
                High_seat_GD_B --;
            }
            if(seat_no%3 == 2)
            {
                High_seat_GD_C --;
            }
        }
        if(this.getSeat_type().equals("一等座"))
        {
            if(seat_no%4 == 0)
            {
                Medium_seat_GD_A--;
            }
            if(seat_no%4 == 1)
            {
                Medium_seat_GD_B--;
            }
            if(seat_no%4 == 2)
            {
                Medium_seat_GD_C--;
            }
            if(seat_no%4 == 3)
            {
                Medium_seat_GD_D--;
            }
        }
        if(this.getSeat_type().equals("二等座"))
        {
            if(seat_no%5 == 0)
            {
               Low_seat_GD_A --;
            }
            if(seat_no%5 == 1)
            {
                Low_seat_GD_B --;
            }
            if(seat_no%5 == 2)
            {
                Low_seat_GD_C --;
            }
            if(seat_no%5 == 3)
            {
                Low_seat_GD_D --;
            }
            if(seat_no%5 == 4)
            {
                Low_seat_GD_E --;
            }
        }
    }

    public int getHigh_seat_GD_A() {
        return High_seat_GD_A;
    }

    public void setHigh_seat_GD_A(int high_seat_GD_A) {
        High_seat_GD_A = high_seat_GD_A;
    }

    public int getHigh_seat_GD_B() {
        return High_seat_GD_B;
    }

    public void setHigh_seat_GD_B(int high_seat_GD_B) {
        High_seat_GD_B = high_seat_GD_B;
    }

    public int getHigh_seat_GD_C() {
        return High_seat_GD_C;
    }

    public void setHigh_seat_GD_C(int high_seat_GD_C) {
        High_seat_GD_C = high_seat_GD_C;
    }

    public int getMedium_seat_GD_A() {
        return Medium_seat_GD_A;
    }

    public void setMedium_seat_GD_A(int medium_seat_GD_A) {
        Medium_seat_GD_A = medium_seat_GD_A;
    }

    public int getMedium_seat_GD_C() {
        return Medium_seat_GD_C;
    }

    public void setMedium_seat_GD_C(int medium_seat_GD_C) {
        Medium_seat_GD_C = medium_seat_GD_C;
    }

    public int getMedium_seat_GD_B() {
        return Medium_seat_GD_B;
    }

    public void setMedium_seat_GD_B(int medium_seat_GD_B) {
        Medium_seat_GD_B = medium_seat_GD_B;
    }

    public int getMedium_seat_GD_D() {
        return Medium_seat_GD_D;
    }

    public void setMedium_seat_GD_D(int medium_seat_GD_D) {
        Medium_seat_GD_D = medium_seat_GD_D;
    }

    public int getLow_seat_GD_A() {
        return Low_seat_GD_A;
    }

    public void setLow_seat_GD_A(int low_seat_GD_A) {
        Low_seat_GD_A = low_seat_GD_A;
    }

    public int getLow_seat_GD_B() {
        return Low_seat_GD_B;
    }

    public void setLow_seat_GD_B(int low_seat_GD_B) {
        Low_seat_GD_B = low_seat_GD_B;
    }

    public int getLow_seat_GD_C() {
        return Low_seat_GD_C;
    }

    public void setLow_seat_GD_C(int low_seat_GD_C) {
        Low_seat_GD_C = low_seat_GD_C;
    }

    public int getLow_seat_GD_D() {
        return Low_seat_GD_D;
    }

    public void setLow_seat_GD_D(int low_seat_GD_D) {
        Low_seat_GD_D = low_seat_GD_D;
    }

    public int getLow_seat_GD_E() {
        return Low_seat_GD_E;
    }

    public void setLow_seat_GD_E(int low_seat_GD_E) {
        Low_seat_GD_E = low_seat_GD_E;
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
}
