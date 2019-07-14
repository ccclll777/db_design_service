package com.example.db_design_service.bean;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 *
 *
 * 用户类  对应与数据库的用户表user
 *
 *
 */
public class User {
    private String user_phone_number;
    private String user_password;
    private String user_email;
    private String user_real_name;
    private int user_type;
    private String user_id_number;
    private int user_gender;
    private String user_address;

    public User(String user_phone_number, String user_password, String user_email , String user_real_name
            , int user_type ,String user_id_number
            ,int user_gender ,String  user_address)
    {
        this.user_phone_number = user_phone_number;
        this.user_password  = user_password;
        this.user_email = user_email;
        this.user_real_name  = user_real_name;
        this.user_type = user_type;
//        this.registration_time  = registration_time;
        this.user_id_number = user_id_number;
        this.user_gender = user_gender;
        this.user_address = user_address;
    }
    public String getUser_phone_number() {
        return user_phone_number;
    }

    public void setUser_phone_number(String user_phone_number) {
        this.user_phone_number = user_phone_number;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_real_name() {
        return user_real_name;
    }

    public void setUser_real_name(String user_real_name) {
        this.user_real_name = user_real_name;
    }

    public int getUser_type() {
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }

//    public Date getRegistration_time() {
//        return registration_time;
//    }
//
//    public void setRegistration_time(Date registration_time) {
//        this.registration_time = registration_time;
//    }

    public int getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(int user_gender) {
        this.user_gender = user_gender;
    }



    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_id_number() {
        return user_id_number;
    }

    public void setUser_id_number(String user_id_number) {
        this.user_id_number = user_id_number;
    }

}
