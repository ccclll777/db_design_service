package com.example.db_design_service.bean;

public class UserInfo {
   private String user_name;
   private String id;
   private String create_time;
   private int status;
   private String city;
   private String avatar;
   private String admin;


    public UserInfo(String user_name, String id, String create_time, int status, String city, String avatar, String admin) {
        this.user_name = user_name;
        this.id = id;
        this.create_time = create_time;
        this.status = status;
        this.city = city;
        this.avatar = avatar;
        this.admin = admin;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}
