package com.example.db_design_service.dao;

import com.example.db_design_service.bean.User;
import com.example.db_design_service.bean.UserLogin;
import org.apache.ibatis.annotations.*;

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
    /**
     * 插入用户信息
     */
    @Insert("INSERT INTO user(name, age,money) VALUES(#{name}, #{age}, #{money})")
    void insertUser(@Param("name") String name, @Param("age") Integer age, @Param("money") Double money);

//    /**
//     * 根据 id 更新用户信息
//     */
//    @Update("UPDATE  user SET name = #{name},age = #{age},money= #{money} WHERE id = #{id}")
//    void updateUser(@Param("name") String name, @Param("age") Integer age, @Param("money") Double money,
//                    @Param("id") int id);
//
//    /**
//     * 根据 id 删除用户信息
//     */
//    @Delete("DELETE from user WHERE id = #{id}")
//    void deleteUser(@Param("id") int id);
}