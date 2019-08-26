package com.example.db_design_service.service;

import com.example.db_design_service.bean.User;
import com.example.db_design_service.bean.UserLogin;
import com.example.db_design_service.dao.UserDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 *
 * 对应userdao的service层
 *
 * 调用userdao关于数据库的操作
 */
@Service
public class UserService {
    @Resource
    private UserDao userDao;


    /**
     *
     * 查找所以用户
     * @return
     */
    public List<User> selectAllUser() {
        return userDao.findAllUser();
    }

    /**
     *
     * 查找所有用户的登陆信息
     * @return
     */
    public List<UserLogin> selectAllUserLogin() {
        return userDao.findAllUserLogin();
    }


    /**
     *
     * 插入用户  注册
     * @param user
     * @return
     */
   public boolean insertUser(User user)
    {
        userDao.insertUser(user);
        return true;
    }

    /**
     *
     * 查询某一用户信息
     * @param user_phone_number
     * @return
     */
    public User selectUserInfo(String user_phone_number)
    {
        return userDao.findUserInfo(user_phone_number);
    }


    /**
     *
     *
     * 更新个人信息
     *
     * @param user_real_name
     * @param user_email
     * @param user_type
     * @param user_gender
     * @param user_id_number
     * @param user_address
     * @param user_phone_number
     */
    public void UpdateUserInfe(String user_real_name, String user_email, int user_type,  int user_gender,  String user_id_number,  String user_address,String user_phone_number)
    {
        userDao.UptateUser(user_real_name,user_email,user_type,user_gender,user_id_number,user_address,user_phone_number);
    }

    /**
     *
     * 修改密码
     * @param user_password
     * @param user_phone_number
     */
    public void UpdatePassword(String user_password,String user_phone_number)
    {
        userDao.UptatePassword(user_password,user_phone_number);
    }


    public void deleteUser(String user_phone_number)
    {
        userDao.deleteUser(user_phone_number);
    }

}
