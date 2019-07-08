package com.example.db_design_service.controller;

import com.example.db_design_service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.db_design_service.bean.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserManagerController {
    @Autowired
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserManagerController.class);



    //    @RequestMapping(value ="/user/login",method = RequestMethod.POST)
//    public void addUser2(HttpServletRequest request) {
//        System.out.println(request);
//        String username=request.getParameter("username");
//        String password=request.getParameter("password");
//
//        logger.info(request.getMethod());
//        logger.info(String.valueOf(request.getParameterNames()));
//        logger.info("password is:"+password);
//
//    }
//    @RequestMapping(value ="/user/login",method = RequestMethod.POST)
//    public RespBean login(@Valid @RequestBody Map<String,Object> request, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            System.out.println(bindingResult.getFieldError().getDefaultMessage());
//        }
//        String userId = (String) request.get("username");
//        String realName = (String) request.get("password");
//        logger.info("登录信息如下");
//        logger.info(userId);
//        logger.info(realName);
//
//        String token = new String("admin-token");
//
//
//        return new RespBean(20000,new Token(token));
//    }

    @RequestMapping(value ="/login",method = RequestMethod.POST)
    public RespBean UserLogin(@Valid @RequestBody Map<String,Object> request, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }
        String username = (String) request.get("username");
        String password = (String) request.get("password");
        List<UserLogin> userlogins = userService.selectAllUserLogin();
        for (UserLogin userlogin : userlogins) {
            if (userlogin.getUser_phone_number().equals(username)  && userlogin.getUser_password().equals(password))
            {
                logger.info("登录信息如下");
                logger.info(username);
                logger.info(password);
                logger.info("登录成功");
                return new RespBean(20000, new Token(userlogin.getUser_phone_number()+"+++"+userlogin.getUser_password()));

            }
            else
            {

                return new RespBean(60204, new Token("admin-token"));
            }
            }

        return new RespBean(60204, new Token("admin-token"));
    }
    @RequestMapping(value ="/info",method = RequestMethod.GET)
    public UserInfo UserInfo(@RequestParam String token) {
        String [] roles = new String[1];
        roles[0] = "admin";

        return new UserInfo(20000,new Data(roles,"111","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif","11111"));
    }
//    @Autowired
//    private jdbc_test test2  ;
//
//    @RequestMapping("/list")
//    private List<user> getStus(){
//        logger.info("从数据库读取Student集合");
//        logger.info(test2.getList().toString());
//        return test2.getList();
//    }

}
