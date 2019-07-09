package com.example.db_design_service.dao;

import com.example.db_design_service.bean.User;
import com.example.db_design_service.bean.UserLogin;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 通过名字查询用户信息
     */
//    @Select("SELECT * FROM user WHERE name = #{name}")
//    User findUserByName(@Param("name") String name);

    /**
     * 查询所有用户信息
     */
    @Select("SELECT * FROM user")
    List<User> findAllUser();

    @Select("SELECT user_phone_number,user_password FROM user")
    List<UserLogin> findAllUserLogin();

    @Select("SELECT * FROM user where user_phone_number=#{user_phone_number}")
    User findUserInfo(@Param("user_phone_number") String user_phone_number);
    /**
     * 插入用户信息
     */

//    @Insert("INSERT INTO user(user_phone_number, user_password,user_email,user_real_name,user_type,registeration_time,user_id_number,user_gender,user_address) " +
//            "VALUES(#{user_phone_number}, #{user_password}, #{user_email},#{user_real_name},#{user_type},#{registeration_time},#{user_id_number},#{user_gender},#{user_address})")
//    void insertUser(@Param("user_phone_number") String user_phone_number, @Param("user_password") String user_password,
//                    @Param("user_email") String user_email, @Param("user_real_name") String user_real_name, @Param("user_type") String user_type, @Param("registeration_time")
//                            Date registeration_time, @Param("user_id_number") String user_id_number, @Param("user_gender") String user_gender, @Param("user_address") String user_address);
    @Insert("insert into  user (user_phone_number,user_password,user_email,user_real_name,user_type,user_id_number,user_gender,user_address) VALUES ( #{user.user_phone_number}, #{user.user_password}, #{user.user_email},#{user.user_real_name},#{user.user_type},#{user.user_id_number},#{user.user_gender},#{user.user_address})")
    void insertUser(@Param("user") User user);

}
