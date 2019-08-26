package com.example.db_design_service.dao;

import com.example.db_design_service.bean.User;
import com.example.db_design_service.bean.UserLogin;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 *
 *
 * mybatis对应数据库用户表的dao层
 * 作为针对用户表的各种业务
 *
 * 查询  插入 更新
 */
@Mapper
public interface UserDao {
    /**
     * 通过名字查询用户信息
     */


    /**
     * 查询所有用户信息
     */
    @Select("SELECT * FROM user")
    List<User> findAllUser();

    /**
     * 查询用户的登陆信息
     *
     * @return
     */
    @Select("SELECT user_phone_number,user_password FROM user")
    List<UserLogin> findAllUserLogin();

    /**
     *
     *
     * 查询某个用户的个人信息
     * @param user_phone_number
     * @return
     */
    @Select("SELECT * FROM user where user_phone_number=#{user_phone_number}")
    User findUserInfo(@Param("user_phone_number") String user_phone_number);
    /**
     * 插入用户信息
     */

    @Insert("insert into  user (user_phone_number,user_password,user_email,user_real_name,user_type,user_id_number,user_gender,user_address) VALUES ( #{user.user_phone_number}, #{user.user_password}, #{user.user_email},#{user.user_real_name},#{user.user_type},#{user.user_id_number},#{user.user_gender},#{user.user_address})")
    void insertUser(@Param("user") User user);

    /**
     *
     *修改用户信息
     *
     * @param user_real_name
     * @param user_email
     * @param user_type
     * @param user_gender
     * @param user_id_number
     * @param user_address
     * @param user_phone_number
     */
    @Update("update user set user_real_name = #{user_real_name} , user_email = #{user_email} , user_type = #{user_type} , user_gender = #{user_gender} ,user_id_number = #{user_id_number} , user_address = #{user_address} where user_phone_number = #{user_phone_number}")
    void UptateUser(@Param("user_real_name") String user_real_name, @Param("user_email") String user_email,@Param("user_type") int user_type,@Param("user_gender") int user_gender,@Param("user_id_number") String user_id_number, @Param("user_address") String user_address, @Param("user_phone_number") String user_phone_number);


    /**
     *
     *
     * 修改密码
     *
     * @param user_password
     * @param user_phone_number
     */
    @Update("update user set user_password = #{user_password} where user_phone_number = #{user_phone_number}")
    void UptatePassword(@Param("user_password") String user_password, @Param("user_phone_number") String user_phone_number);


    @Delete("delete from user where user_phone_number = #{user_phone_number}")
    void deleteUser(@Param("user_phone_number")String user_phone_number);

}
