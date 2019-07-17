package com.example.db_design_service.controller;


import com.example.db_design_service.RedisUtils;
import com.example.db_design_service.bean.*;
import com.example.db_design_service.service.TrainParkingStationService;
import com.example.db_design_service.service.TrainTickerQueryService;
import com.example.db_design_service.service.TrainTicketOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class TrainTicketOrderController {


    @Resource
    private TrainTickerQueryService trainTickerQueryService;

    @Resource
    private TrainTicketOrderService trainTicketOrderService;

    @Resource
    private TrainParkingStationService trainParkingStationService;
    @Resource
    private RedisUtils redisUtils;

    private static final Logger logger = LoggerFactory.getLogger(TrainTicketOrderController.class);

    @RequestMapping(value ="/orderTrainTicket",method = RequestMethod.POST)
    public TrainTicketOrderReturnData UserLogin(@Valid @RequestBody Map<String,Object> request, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }
        String token = (String) request.get("token");
        String datetime = (String) request.get("datetime");
        String train_no  =(String) request.get("train_no");
        String start_no = (String) request.get("start_no");
        String end_no = (String) request.get("end_no");
        String train_number  =(String) request.get("train_number");
        String carriage_no = (String) request.get("carriage_no");
        String seat_type = (String) request.get("seat_type");
        String seat_number  =(String) request.get("seat_number");
        String passenger_phone_number  =(String) request.get("passenger_phone_number");
        String passenger_id_number  =(String) request.get("passenger_id_number");
        String high_seat_price  =(String) request.get("high_seat_price");
        String medium_seat_price  =(String) request.get("medium_seat_price");
        String low_seat_price  =(String) request.get("low_seat_price");

        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdfs =
                new java.text.SimpleDateFormat("yyyy-MM-dd");
        String order_create_time = sdfs.format(dt);


        String user = redisUtils.get(token);

        String data [] = user.split(",");

        String user_phone_number = data[1];
        logger.info("user_phone_number");
        logger.info(user_phone_number);
        String start_station_name = trainParkingStationService.searchStation_name(train_no,start_no);
        String end_station_name = trainParkingStationService.searchStation_name(train_no,end_no);

        List<TrainSeatQuery> trainCarriageSeatCountList =trainTickerQueryService.queryCarriageSeatQuery(train_no,carriage_no,start_no,end_no,datetime);
        List<TrainSeatCount> trainSeatCountList  = trainTickerQueryService.queryCarriageSeatCount(train_no,carriage_no);

        int Seat_count = trainSeatCountList.get(0).getSeat_count();
        String Seat_type = trainSeatCountList.get(0).getSeat_type();
        int result_seat_no = 0;
        String result_seat = null;
        OrderList orderList = null ;
        if(train_number.substring(0,1).equals("G") || train_number.substring(0,1).equals("D"))
        {
            result_seat_no = GetSeat_no_GD(Seat_type,Seat_count,seat_number,trainCarriageSeatCountList);
            result_seat = GetResult_Seat_no(Seat_type,seat_number,result_seat_no);
            if(Seat_type.equals("特等座"))
            {
                orderList = new OrderList(user_phone_number,passenger_phone_number,passenger_id_number,train_no,start_no,start_station_name,end_no,end_station_name,carriage_no,String.valueOf(result_seat_no),high_seat_price,order_create_time,"未支付",datetime);

            }
            if(Seat_type.equals("一等座"))
            {
                orderList = new OrderList(user_phone_number,passenger_phone_number,passenger_id_number,train_no,start_no,start_station_name,end_no,end_station_name,carriage_no,String.valueOf(result_seat_no),medium_seat_price,order_create_time,"未支付",datetime);
            }
            if(Seat_type.equals("二等座"))
            {
                orderList = new OrderList(user_phone_number,passenger_phone_number,passenger_id_number,train_no,start_no,start_station_name,end_no,end_station_name,carriage_no,String.valueOf(result_seat_no),low_seat_price,order_create_time,"未支付",datetime);
            }
                trainTicketOrderService.addOrder(orderList);

            }

        else
        {
            result_seat_no = GetSeat_no(Seat_type,Seat_count,seat_number,trainCarriageSeatCountList);
            result_seat = GetResult_Seat_no(Seat_type,seat_number,result_seat_no);
            if(Seat_type.equals("软卧"))
            {
                orderList = new OrderList(user_phone_number,passenger_phone_number,passenger_id_number,train_no,start_no,start_station_name,end_no,end_station_name,carriage_no,String.valueOf(result_seat_no),high_seat_price,order_create_time,"未支付",datetime);
            }
            if(Seat_type.equals("硬卧"))
            {
                orderList = new OrderList(user_phone_number,passenger_phone_number,passenger_id_number,train_no,start_no,start_station_name,end_no,end_station_name,carriage_no,String.valueOf(result_seat_no),medium_seat_price,order_create_time,"未支付",datetime);
            }
            if(Seat_type.equals("硬坐"))
            {
                orderList = new OrderList(user_phone_number,passenger_phone_number,passenger_id_number,train_no,start_no,start_station_name,end_no,end_station_name,carriage_no,String.valueOf(result_seat_no),low_seat_price,order_create_time,"未支付",datetime);
            }
            trainTicketOrderService.addOrder(orderList);
        }
        return new TrainTicketOrderReturnData(1,carriage_no,seat_type,result_seat,passenger_phone_number);

    }


    private String GetResult_Seat_no(String Seat_type,String Seat_number,int seat_no)
    {
            String result_seat = null;
            if(Seat_type.equals("特等座") )
            {

              result_seat = String.valueOf(seat_no/3 +1) +"排"+Seat_number +"座";

            }

        if(Seat_type.equals("一等座") )
        {
            result_seat = String.valueOf(seat_no/4 +1) +"排"+Seat_number +"座";
        }
        if(Seat_type.equals("二等座") )
        {
            result_seat = String.valueOf(seat_no/5 +1) +"排"+Seat_number +"座";
        }
        if(Seat_type.equals("软卧") )
        {

            result_seat = String.valueOf(seat_no/2 +1) +"排"+Seat_number ;

        }

        if(Seat_type.equals("硬卧") )
        {
            result_seat = String.valueOf(seat_no/3 +1) +"排"+Seat_number;
        }
        if(Seat_type.equals("硬坐") )
        {
            result_seat = String.valueOf(seat_no/6 +1) +"排"+Seat_number +"座";
        }
            return result_seat;
    }
    /**
     *
     * 高铁动车选座算法
     *
     * 根据座位类型和座位号筛选座位
     *
     * @param Seat_type
     * @param Seat_count
     * @param Seat_number
     * @param trainCarriageSeatCountList
     * @return
     */
    private int GetSeat_no_GD(String Seat_type,int Seat_count,String Seat_number, List<TrainSeatQuery> trainCarriageSeatCountList)
    {

        int seat_no = 0 ;
        if(Seat_type.equals("特等座"))
        {
            if(Seat_number.equals("A"))
            {

                seat_no = getSeat_no_count(Seat_count,0,3,trainCarriageSeatCountList);
            }
            if(Seat_number.equals("B"))
            {

                seat_no = getSeat_no_count(Seat_count,1,3,trainCarriageSeatCountList);
            }
            if(Seat_number.equals("C"))
            {
                seat_no = getSeat_no_count(Seat_count,2,3,trainCarriageSeatCountList);
            }

        }
        if(Seat_type.equals("一等座"))
        {

            if(Seat_number.equals("A"))
            {
                seat_no = getSeat_no_count(Seat_count,0,4,trainCarriageSeatCountList);
            }
            if(Seat_number.equals("B"))
            {
                seat_no = getSeat_no_count(Seat_count,1,4,trainCarriageSeatCountList);
            }
            if(Seat_number.equals("C"))
            {
                seat_no = getSeat_no_count(Seat_count,2,4,trainCarriageSeatCountList);
            }
            if(Seat_number.equals("D"))
            {
                seat_no = getSeat_no_count(Seat_count,3,4,trainCarriageSeatCountList);
            }
        }

        if(Seat_type.equals("二等座"))
        {

            if(Seat_number.equals("A"))
            {
                seat_no = getSeat_no_count(Seat_count,0,5,trainCarriageSeatCountList);
            }
            if(Seat_number.equals("B"))
            {
                seat_no = getSeat_no_count(Seat_count,1,5,trainCarriageSeatCountList);
            }
            if(Seat_number.equals("C"))
            {
                seat_no = getSeat_no_count(Seat_count,2,5,trainCarriageSeatCountList);
            }
            if(Seat_number.equals("D"))
            {
                seat_no = getSeat_no_count(Seat_count,3,5,trainCarriageSeatCountList);
            }
            if(Seat_number.equals("E"))
            {
                seat_no = getSeat_no_count(Seat_count,4,5,trainCarriageSeatCountList);
            }
        }

        return seat_no;
    }

    /**
     *
     * 具体的高铁动车选座算法 根据不同的 要求进行选座
     * @param Seat_count
     * @param start
     * @param interval
     * @param trainCarriageSeatCountList
     * @return
     */
    private int getSeat_no_count(int Seat_count,int start,int interval,List<TrainSeatQuery> trainCarriageSeatCountList)
    {
        int seat_no = 0;
        boolean flag = false;
        for(int i = start ; i< Seat_count ; i = i+interval)
        {
            for(TrainSeatQuery trainSeatQuery :trainCarriageSeatCountList)
            {

                int temp = Integer.parseInt(trainSeatQuery.getSeat_no());
                logger.info(String.valueOf(i) +"    "+ String.valueOf(temp) );
                if(temp%interval == start)
                {
                    if(temp != i)
                    {
                        seat_no = i;
                        flag =true;
                        break;
                    }
                }
            }
            if(flag)
            {
                break;
            }
        }
        return seat_no;
    }

    /**
     *
     *
     * 其他列车选座
     * @param Seat_type
     * @param Seat_count
     * @param Seat_number
     * @param trainCarriageSeatCountList
     * @return
     */
    private int GetSeat_no(String Seat_type,int Seat_count,String Seat_number, List<TrainSeatQuery> trainCarriageSeatCountList)
    {

        int seat_no = 0 ;
        if(Seat_type.equals("软卧"))
        {
            if(Seat_number.equals("上铺"))
            {

                seat_no = getSeat_no_count(Seat_count,0,2,trainCarriageSeatCountList);
            }
            if(Seat_number.equals("下铺"))
            {

                seat_no = getSeat_no_count(Seat_count,1,2,trainCarriageSeatCountList);
            }


        }
        if(Seat_type.equals("硬卧"))
        {

            if(Seat_number.equals("上铺"))
            {
                seat_no = getSeat_no_count(Seat_count,0,3,trainCarriageSeatCountList);
            }
            if(Seat_number.equals("中铺"))
            {
                seat_no = getSeat_no_count(Seat_count,1,3,trainCarriageSeatCountList);
            }
            if(Seat_number.equals("下铺"))
            {
                seat_no = getSeat_no_count(Seat_count,2,3,trainCarriageSeatCountList);
            }

        }

        if(Seat_type.equals("硬坐"))
        {

            if(Seat_number.equals("A"))
            {
                seat_no = getSeat_no_count(Seat_count,0,6,trainCarriageSeatCountList);
            }
            if(Seat_number.equals("B"))
            {
                seat_no = getSeat_no_count(Seat_count,1,6,trainCarriageSeatCountList);
            }
            if(Seat_number.equals("C"))
            {
                seat_no = getSeat_no_count(Seat_count,2,6,trainCarriageSeatCountList);
            }
            if(Seat_number.equals("D"))
            {
                seat_no = getSeat_no_count(Seat_count,3,6,trainCarriageSeatCountList);
            }
            if(Seat_number.equals("E"))
            {
                seat_no = getSeat_no_count(Seat_count,4,6,trainCarriageSeatCountList);
            }
            if(Seat_number.equals("F"))
            {
                seat_no = getSeat_no_count(Seat_count,5,6,trainCarriageSeatCountList);
            }
        }

        return seat_no;
    }


    @RequestMapping(value ="/getOrderList",method = RequestMethod.GET)
    public GetOrderListReturnData GetUserInfo(@RequestParam String token,String datetime,String train_no,String start_no,String end_no) {

        String user = redisUtils.get(token);

        String data [] = user.split(",");

        String user_phone_number = data[1];
        List<GetOrderList> orderLists = trainTicketOrderService.getOrderList(user_phone_number,datetime,train_no,start_no,end_no);

        return  new GetOrderListReturnData(1,orderLists);

    }


    @RequestMapping(value ="/paySuccess",method = RequestMethod.GET)
    public void PaySuccess(@RequestParam String token,String datetime,String train_no,String start_no,String end_no) {

    
    }
}
