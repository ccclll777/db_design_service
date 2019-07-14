package com.example.db_design_service.bean;
/**
 *
 *
 * 用户类  对应前端的个人信息查询
 *
 *在查询个人信息时作为给前端的返回数据
 */
public class UserInfo {
    private String user_real_name;
    private String user_phone_number;
    private String user_email;
    private String user_type;
    private String user_gender;
    private String user_id_number;
    private String user_address;

    public UserInfo(String user_real_name, String user_phone_number, String user_email, String user_type, String user_gender, String user_id_number, String user_address) {
        this.user_real_name = user_real_name;
        this.user_phone_number = user_phone_number;
        this.user_email = user_email;
        this.user_type = user_type;
        this.user_gender = user_gender;
        this.user_id_number = user_id_number;
        this.user_address = user_address;
    }

    public String getUser_real_name() {
        return user_real_name;
    }

    public void setUser_real_name(String user_real_name) {
        this.user_real_name = user_real_name;
    }

    public String getUser_phone_number() {
        return user_phone_number;
    }

    public void setUser_phone_number(String user_phone_number) {
        this.user_phone_number = user_phone_number;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
    }

    public String getUser_id_number() {
        return user_id_number;
    }

    public void setUser_id_number(String user_id_number) {
        this.user_id_number = user_id_number;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }
//   private String user_name;
//   private String id;
//   private String create_time;
//   private int status;
//   private String city;
//   private String avatar;
//   private String admin;
//
//
//    public UserInfo(String user_name, String id, String create_time, int status, String city, String avatar, String admin) {
//        this.user_name = user_name;
//        this.id = id;
//        this.create_time = create_time;
//        this.status = status;
//        this.city = city;
//        this.avatar = avatar;
//        this.admin = admin;
//    }
//
//    public String getUser_name() {
//        return user_name;
//    }
//
//    public void setUser_name(String user_name) {
//        this.user_name = user_name;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getCreate_time() {
//        return create_time;
//    }
//
//    public void setCreate_time(String create_time) {
//        this.create_time = create_time;
//    }
//
//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getAvatar() {
//        return avatar;
//    }
//
//    public void setAvatar(String avatar) {
//        this.avatar = avatar;
//    }
//
//    public String getAdmin() {
//        return admin;
//    }
//
//    public void setAdmin(String admin) {
//        this.admin = admin;
//    }
}
