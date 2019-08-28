package com.example.db_design_service.controller;

import com.example.db_design_service.RedisUtils;
import com.example.db_design_service.bean.*;
import com.example.db_design_service.service.PassengerService;
import com.example.db_design_service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;


/**
 *
 * 乘客管理的业务处理层
 */
@RestController
@RequestMapping("/passenger")
public class PassengerManagerController {

    @Resource
    private PassengerService passengerService;
    @Resource
    private RedisUtils redisUtils;

    private static final Logger logger = LoggerFactory.getLogger(PassengerManagerController.class);

    /**
     *
     * 根据用户  获取此用户下的乘客信息
     *
     * 对应前端的getPassengerInfo请求
     * @param token
     * @return
     */
    @RequestMapping(value ="/getPassengerInfo",method = RequestMethod.GET)
    public PassengerInfoReturnData getPassengerInfo(@RequestParam String token) {

        logger.info(redisUtils.get(token));
        String user = redisUtils.get(token);
        String data [] = user.split(",");
        String user_phone_number = data[1];
        List<PassengerInfo> passengerInfoList = passengerService.selectPassenger(user_phone_number);
        logger.info(String.valueOf(passengerInfoList.size()));
        return new PassengerInfoReturnData(1,passengerInfoList);


    }

    /**
     *
     * 用户添加乘客
     * 对应前端的addPassengerInfo请求
     * @param request
     * @param bindingResult
     * @return
     */
    @RequestMapping(value ="/addPassengerInfo",method = RequestMethod.POST)
    public RespBean UserRegister(@Valid @RequestBody Map<String,Object> request, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }
        String token = (String) request.get("token");
        String passenger_phone_number = (String) request.get("passenger_phone_number");
        String passenger_real_name = (String) request.get("passenger_real_name");
        String  passenger_id_number = (String)request.get("passenger_id_number");
        String  passenger_type = (String)request.get("passenger_type");
        String passenger_address = (String) request.get("passenger_address");
        String user = redisUtils.get(token);
        String data [] = user.split(",");
        String user_phone_number = data[1];

        logger.info(passenger_address);
        logger.info(passenger_id_number);
        int type = 0 ;
        if(passenger_type.equals("成人"))
        {
            type = 1;
        }
        else if(passenger_type.equals("学生"))
        {
            type = 0;
        }
        try {
            passengerService.insertPassenger(user_phone_number,passenger_phone_number,passenger_real_name,passenger_id_number,type,passenger_address);
            return new RespBean(1,"添加成功");
        }
        catch (Exception e)
        {
            logger.info(e.getMessage());
            return new RespBean(405,"添加失败");
        }



    }


    /**
     *
     * 删除乘客信息
     * 对应前端的deletePassengerInfo请求
     * @param token
     * @param passenger_phone_number
     * @return
     */
    @RequestMapping(value ="/deletePassengerInfo",method = RequestMethod.GET)
    public RespBean DeletePassengerInfo(@RequestParam String token,String passenger_phone_number) {

        String user = redisUtils.get(token);
        String data [] = user.split(",");
        String user_phone_number = data[1];
        try {
            passengerService.deletePassenger(user_phone_number,passenger_phone_number);
            return new RespBean(1,"删除成功");
        }
        catch (Exception e)
        {
            return new RespBean(405,"删除失败");
        }

        

    }

    @RequestMapping(value ="/getPassengerInfoByNumber",method = RequestMethod.GET)
    public PassengerInfoReturnData searchPassengerByNumber(@RequestParam String passenger_phone_number) {


            logger.info(passenger_phone_number);
            List<PassengerInfo> passengerInfoList = passengerService.selectPassengerBynumber(passenger_phone_number);
            return new PassengerInfoReturnData(1,passengerInfoList);
    }

    @RequestMapping(value ="/deletePassenger",method = RequestMethod.GET)
    public RespBean deletePassenger(@RequestParam String user_phone_number,String passenger_phone_number) {


        try {
            passengerService.deletePassenger(user_phone_number,passenger_phone_number);
            return new RespBean(1,"删除成功");
        }
        catch (Exception e)
        {
            return new RespBean(405,"删除失败");
        }



    }

}
