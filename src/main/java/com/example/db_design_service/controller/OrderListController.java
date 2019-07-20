package com.example.db_design_service.controller;

import com.example.db_design_service.RedisUtils;
import com.example.db_design_service.bean.GetAllOrderList;
import com.example.db_design_service.bean.GetAllOrderListReturnData;
import com.example.db_design_service.service.OrderListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderListController {

    @Resource
    private OrderListService orderListService;


    @Resource
    private RedisUtils redisUtils;


    private static final Logger logger = LoggerFactory.getLogger(OrderListController.class);

    @RequestMapping(value ="/getAllOrderList",method = RequestMethod.GET)
    public GetAllOrderListReturnData GetAllOrderList(@RequestParam String token) {

        logger.info(token);

        String user = redisUtils.get(token);

        String data [] = user.split(",");

        String user_phone_number = data[1];

        List<GetAllOrderList> getAllOrderListLists = orderListService.getAllOrderLists(user_phone_number);
       for(GetAllOrderList getAllOrderList :getAllOrderListLists)
       {
           getAllOrderList.setSeat_no(GetResult_Seat_no(getAllOrderList.getSeat_type(), Integer.parseInt(getAllOrderList.getSeat_no())));
       }

        return new GetAllOrderListReturnData(1,getAllOrderListLists);
    }

    private String GetResult_Seat_no(String Seat_type,int seat_no)
    {
        String result_seat = null;
        if(Seat_type.equals("特等座") )
        {


            result_seat = String.valueOf(seat_no/3 +1) +"排";
            if(seat_no%3 == 0)
            {
                result_seat +="A座";
            }
            if(seat_no%3 == 1)
            {
                result_seat +="B座";
            }
            if(seat_no%3 == 2)
            {
                result_seat +="C座";
            }


        }

        if(Seat_type.equals("一等座") )
        {
            result_seat = String.valueOf(seat_no/4 +1) +"排";
            if(seat_no%4 == 0)
            {
                result_seat +="A座";
            }
            if(seat_no%4 == 1)
            {
                result_seat +="B座";
            }
            if(seat_no%4 == 2)
            {
                result_seat +="C座";
            }
            if(seat_no%4 == 3)
            {
                result_seat +="D座";
            }
        }
        if(Seat_type.equals("二等座") )
        {
            result_seat = String.valueOf(seat_no/5 +1) +"排";
            if(seat_no%5 == 0)
            {
                result_seat +="A座";
            }
            if(seat_no%5 == 1)
            {
                result_seat +="B座";
            }
            if(seat_no%5 == 2)
            {
                result_seat +="C座";
            }
            if(seat_no%5 == 3)
            {
                result_seat +="D座";
            }
            if(seat_no%5 == 4)
            {
                result_seat +="E座";
            }
        }
        if(Seat_type.equals("软卧") )
        {

            result_seat = String.valueOf(seat_no/2 +1) +"排" ;
            if(seat_no%2 == 0)
            {
                result_seat +="上铺";
            }
            if(seat_no%2 == 1)
            {
                result_seat +="下铺";
            }

        }

        if(Seat_type.equals("硬卧") )
        {
            result_seat = String.valueOf(seat_no/3 +1) +"排";
            if(seat_no%3 == 0)
            {
                result_seat +="上铺";
            }
            if(seat_no%3 == 1)
            {
                result_seat +="中铺";
            }
            if(seat_no%3 == 2)
            {
                result_seat +="下铺";
            }

        }
        if(Seat_type.equals("硬坐") )
        {
            result_seat = String.valueOf(seat_no/6 +1) +"排";
            if(seat_no%6 == 0)
            {
                result_seat +="A座";
            }
            if(seat_no%6 == 1)
            {
                result_seat +="B座";
            }
            if(seat_no%6 == 2)
            {
                result_seat +="C座";
            }
            if(seat_no%6 == 3)
            {
                result_seat +="D座";
            }
            if(seat_no%6 == 4)
            {
                result_seat +="E座";
            }
            if(seat_no%6 == 5)
            {
                result_seat +=" F座";
            }
        }
        return result_seat;
    }
    @RequestMapping(value ="/getNotripOrderList",method = RequestMethod.GET)
    public GetAllOrderListReturnData GetNoTripOrderList(@RequestParam String token) {

        logger.info(token);
        String user = redisUtils.get(token);

        String data [] = user.split(",");

        String user_phone_number = data[1];
        List<GetAllOrderList> getNotripOrderListLists = orderListService.getNotripOrderLists(user_phone_number);
        logger.info(String.valueOf(getNotripOrderListLists.size()));
        for(GetAllOrderList getAllOrderList :getNotripOrderListLists)
        {
            getAllOrderList.setSeat_no(GetResult_Seat_no(getAllOrderList.getSeat_type(), Integer.parseInt(getAllOrderList.getSeat_no())));

        }
        return new GetAllOrderListReturnData(1,getNotripOrderListLists);

    }

    @RequestMapping(value ="/getNoPayOrderList",method = RequestMethod.GET)
    public GetAllOrderListReturnData GetNoPauOrderList(@RequestParam String token) {

        logger.info(token);
        String user = redisUtils.get(token);

        String data [] = user.split(",");

        String user_phone_number = data[1];
        List<GetAllOrderList> getNoPayOrderListLists = orderListService.getNopayOrderLists(user_phone_number);
        logger.info(String.valueOf(getNoPayOrderListLists.size()));
        for(GetAllOrderList getAllOrderList :getNoPayOrderListLists)
        {
            getAllOrderList.setSeat_no(GetResult_Seat_no(getAllOrderList.getSeat_type(), Integer.parseInt(getAllOrderList.getSeat_no())));

        }
        return new GetAllOrderListReturnData(1,getNoPayOrderListLists);

    }

}
