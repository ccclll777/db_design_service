package com.example.db_design_service.bean;

import javax.xml.crypto.Data;

public class User {
    private String user_phone_number;
    private String user_password;
    private String user_email;
    private String user_real_name;
    private int user_type;
    private Data registration_time;
    private String user_id_number;
    private int user_gender;
    private String user_birthday;
    private String user_pay_password;
    private String user_security_question;
    private String getUser_security_answer;
    private String user_address;

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

    public Data getRegistration_time() {
        return registration_time;
    }

    public void setRegistration_time(Data registration_time) {
        this.registration_time = registration_time;
    }

    public int getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(int user_gender) {
        this.user_gender = user_gender;
    }

    public String getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(String user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getUser_security_question() {
        return user_security_question;
    }

    public void setUser_security_question(String user_security_question) {
        this.user_security_question = user_security_question;
    }

    public String getGetUser_security_answer() {
        return getUser_security_answer;
    }

    public void setGetUser_security_answer(String getUser_security_answer) {
        this.getUser_security_answer = getUser_security_answer;
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

    public String getUser_pay_password() {
        return user_pay_password;
    }

    public void setUser_pay_password(String user_pay_password) {
        this.user_pay_password = user_pay_password;
    }
}
