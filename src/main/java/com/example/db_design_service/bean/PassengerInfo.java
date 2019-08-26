package com.example.db_design_service.bean;

/**、
 *乘客类   对应数据的passenger表
 *
 *提供get和set方法已经构造方法
 *
 */
public class PassengerInfo {
    private String user_phone_number;
    private String passenger_real_name;
    private String passenger_phone_number;
    private String passenger_id_number;
    private String passenger_type;
    private String passenger_address;

    public PassengerInfo(String user_phone_number, String passenger_real_name, String passenger_phone_number, String passenger_id_number, String passenger_type, String passenger_address) {
        this.user_phone_number = user_phone_number;
        this.passenger_real_name = passenger_real_name;
        this.passenger_phone_number = passenger_phone_number;
        this.passenger_id_number = passenger_id_number;
        this.passenger_type = passenger_type;
        this.passenger_address = passenger_address;
    }

    public PassengerInfo(String passenger_real_name, String passenger_phone_number, String passenger_id_number, String passenger_type, String passenger_address) {
        this.passenger_real_name = passenger_real_name;
        this.passenger_phone_number = passenger_phone_number;
        this.passenger_id_number = passenger_id_number;
        this.passenger_type = passenger_type;
        this.passenger_address = passenger_address;
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

    public String getPassenger_type() {
        return passenger_type;
    }

    public void setPassenger_type(String passenger_type) {
        this.passenger_type = passenger_type;
    }

    public String getPassenger_address() {
        return passenger_address;
    }

    public void setPassenger_address(String passenger_address) {
        this.passenger_address = passenger_address;
    }

    public String getUser_phone_number() {
        return user_phone_number;
    }

    public void setUser_phone_number(String user_phone_number) {
        this.user_phone_number = user_phone_number;
    }
}
