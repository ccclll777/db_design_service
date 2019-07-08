package com.example.db_design_service.bean;

public class Data {

    private String [] roles;
    private String introduction;
    private String avatar;
    private String name;
    public Data(String[] roles , String introduction, String avatar, String name)
    {
        this.roles = roles;
        this.introduction = introduction;
        this.avatar = avatar;
        this.name = name;
    }
    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
