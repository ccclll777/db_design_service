package com.example.db_design_service.controller;

import com.example.db_design_service.RedisUtils;
import com.example.db_design_service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.db_design_service.bean.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserManagerController {
    @Resource
    private UserService userService;
    @Resource
    private RedisUtils redisUtils;
    private static final Logger logger = LoggerFactory.getLogger(UserManagerController.class);
    @RequestMapping(value ="/login",method = RequestMethod.POST)
    public RespBean UserLogin(@Valid @RequestBody Map<String,Object> request, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }
        String username = (String) request.get("user_name");
        String password = (String) request.get("password");
        List<UserLogin> userlogins = userService.selectAllUserLogin();

        for (UserLogin userlogin : userlogins) {
            if (userlogin.getUser_phone_number().equals(username)  && userlogin.getUser_password().equals(password))
            {
                logger.info("登录信息如下");
                logger.info(username);
                logger.info(password);
                logger.info("登录成功");

                //token生成  用户信息redis缓存
                User user  = userService.selectUserInfo(userlogin.getUser_phone_number());
                String token =user.getUser_real_name()+","+user.getUser_phone_number()+","+user.getUser_email()+","+"1"+","+user.getUser_address()
                        +","+user.getUser_gender()+","+user.getUser_real_name();
                //                Token token =new Token(userlogin.getUser_phone_number()+"+++"+userlogin.getUser_password());
//                String [] roles= new String[1];
//                roles[0] = "admin";
//                User user = userService.selectUserInfo(userlogin.getUser_phone_number());
//                UserInfoReturnData data = new UserInfoReturnData(roles,user.getUser_phone_number(),user.getUser_id_number(),user.getUser_real_name());
                        redisUtils.set(userlogin.getUser_phone_number()+"msbfajshbadsmnfbasmfa"+userlogin.getUser_password(),token);
//                        redisUtils.get(token.getToken());

                return new RespBean(1,userlogin.getUser_phone_number()+"msbfajshbadsmnfbasmfa"+userlogin.getUser_password());

            }
            }
        logger.info("登录失败");
        return new RespBean(404, "失败");
    }
    @RequestMapping(value ="/info",method = RequestMethod.GET)
    public UserInfoReturnData GetUserInfo(@RequestParam String token) {
        String [] roles = new String[1];
        logger.info(token);
        String a = redisUtils.get(token);
        String data [] = a.split(",");
        logger.info(a);
        return new UserInfoReturnData(1,new UserInfo(data[0],data[1],data[2],1,data[3],data[4],data[5]));
    }
    @RequestMapping(value ="/register",method = RequestMethod.POST)
    public RespBean UserRegister(@Valid @RequestBody Map<String,Object> request, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }
        String username = (String) request.get("user_phone_number");
        String password = (String) request.get("user_password");
        String user_password_2 = (String)request.get("user_password_2");
        String user_real_name = (String)request.get("user_real_name");
        String user_email = (String) request.get("user_email");
        String user_id_number = (String)request.get("user_id_number");
        String user_gender = (String )request.get("user_gender");
        String user_address = (String)request.get("user_address");
        String user_type = (String)request.get("user_type");
        List<UserLogin> userlogins = userService.selectAllUserLogin();
        for (UserLogin userlogin : userlogins) {
            if(userlogin.getUser_phone_number().equals(username))
            {
                logger.info("重复");
                return new RespBean(403,"用户名重复");


            }
            else if(!user_password_2.equals(password))
            {
                logger.info("两次输入不相同");
                return new RespBean(404,"两次输入不相同");
            }
            else
            {
                int type = 0 ;
                if(user_type.equals("成人"))
                {
                    type = 1;
                }
                else if(user_type.equals("学生"))
                {
                    type = 0;
                }
                int gender = -1;
                if(user_gender.equals("女"))
                {
                    gender = 0;
                }
                else if(user_gender.equals("男"))
                {
                    gender = 1;
                }
                try {
                    User user  = new User(username,password,user_email,user_real_name,type,user_id_number,gender,user_address);
                    boolean flag = userService.insertUser(user);
                    if(flag)
                    {
                        logger.info("注册成功");
                        return new RespBean(1,userlogin.getUser_phone_number()+"msbfajshbadsmnfbasmfa"+userlogin.getUser_password());
                    }
                    else
                    {
                        logger.info("注册失败");
                        return new RespBean(405,"注册失败");
                    }
                }
                catch (Exception e)
                {
                    logger.info("注册失败");
                    return new RespBean(403,"用户名重复");
                }


            }
        }
        return new RespBean(405,"注册失败");

    }


}
