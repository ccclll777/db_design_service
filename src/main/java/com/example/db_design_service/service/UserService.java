package com.example.db_design_service.service;

import com.example.db_design_service.bean.User;
import com.example.db_design_service.bean.UserLogin;
import com.example.db_design_service.dao.UserDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;
@Service
public class UserService {
    @Resource
    private UserDao userDao;


    public List<User> selectAllUser() {
        return userDao.findAllUser();
    }

    public List<UserLogin> selectAllUserLogin() {
        return userDao.findAllUserLogin();
    }

   public boolean insertUser(User user)
    {
        userDao.insertUser(user);
        return true;
    }
    public User selectUserInfo(String user_phone_number)
    {
        return userDao.findUserInfo(user_phone_number);
    }

    public void UpdateUserInfe(String user_real_name, String user_email, int user_type,  int user_gender,  String user_id_number,  String user_address,String user_phone_number)
    {
        userDao.UptateUser(user_real_name,user_email,user_type,user_gender,user_id_number,user_address,user_phone_number);
    }
    public void UpdatePassword(String user_password,String user_phone_number)
    {
        userDao.UptatePassword(user_password,user_phone_number);
    }
}
