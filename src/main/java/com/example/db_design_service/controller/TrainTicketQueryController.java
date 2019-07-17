package com.example.db_design_service.controller;

import com.example.db_design_service.RedisUtils;
import com.example.db_design_service.bean.*;
import com.example.db_design_service.service.TrainScheduleService;
import com.example.db_design_service.service.TrainTickerQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 车票查询的业务处理层
 *
 * 查询车票价格 余票数量 等
 *
 *
 */
@RestController
@RequestMapping("/query")
public class TrainTicketQueryController {

    @Resource
    private TrainTickerQueryService trainTickerQueryService;

    @Resource
    private TrainScheduleService trainScheduleService;

    @Resource
    private RedisUtils redisUtils;
    private static final Logger logger = LoggerFactory.getLogger(TrainTicketQueryController.class);

    /**
     *
     * 根据出发地 目的地查询票价以及出行时间
     *
     * 对应前端的queryTrainTicket请求
     * @param train_start_station
     * @param train_end_station
     * @param datetime
     */
    @RequestMapping(value ="/queryTrainTicket",method = RequestMethod.GET)
    public TrainTicketPriceQueryReturnData GetTrainScheduleInfo(@RequestParam String train_start_station, String train_end_station, String datetime) {


        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdfs =
                new java.text.SimpleDateFormat("yyyy-MM-dd");
        String currentTime = sdfs.format(dt);
        if(datetime.compareTo(currentTime)<0)
        {
            return new TrainTicketPriceQueryReturnData(406,null);
        }
            List<TrainScheduleInfo> trainScheduleInfos = trainScheduleService.searchTrainScheduleInfo(train_start_station,train_end_station);
            List<TrainTicketPriceInfo> trainTicketPriceInfos = new ArrayList<>();
            for(TrainScheduleInfo trainScheduleInfo :trainScheduleInfos)
            {
                    if(trainScheduleInfo.getTrain_number().substring(0,1).equals("G") ||trainScheduleInfo.getTrain_number().substring(0,1).equals("D"))
                    {

                        trainTicketPriceInfos.add(trainTickerQueryService.queryTicketPrice_GD(train_start_station,train_end_station,trainScheduleInfo.getTrain_no()));
                    }
                    else
                    {
                        trainTicketPriceInfos.add(trainTickerQueryService.queryTicketPrice(train_start_station,train_end_station,trainScheduleInfo.getTrain_no()));

                    }
            }
            String high_price_GD = null;
            String medium_price_GD = null;
            String low_price_GD = null;
            String high_price  = null;
            String medium_price = null;
            String low_price = null;
        for (int i = 0; i < trainTicketPriceInfos.size(); i++) {
            if (trainTicketPriceInfos.get(i) == null || trainTicketPriceInfos.contains(null)) {
                trainTicketPriceInfos.remove(null);
            }
        }
            for(TrainTicketPriceInfo trainTicketPriceInfo :trainTicketPriceInfos)
            {
                if( trainTicketPriceInfo != null) {
                    if(trainTicketPriceInfo.getTrain_number().substring(0,1).equals("G") ||trainTicketPriceInfo.getTrain_number().substring(0,1).equals("D"))
                    {
                        if(!trainTicketPriceInfo.getHigh_seat_price().equals(""))
                        {
                            high_price_GD =trainTicketPriceInfo.getHigh_seat_price();
                        }
                        if(!trainTicketPriceInfo.getMedium_seat_price().equals(""))
                        {
                            medium_price_GD =trainTicketPriceInfo.getMedium_seat_price();
                        }
                        if(!trainTicketPriceInfo.getLow_seat_price().equals(""))
                        {
                            low_price_GD =trainTicketPriceInfo.getLow_seat_price();
                        }

                    }
                    else
                    {
                        if(!trainTicketPriceInfo.getHigh_seat_price().equals(""))
                        {
                            high_price =trainTicketPriceInfo.getHigh_seat_price();
                        }
                        if(!trainTicketPriceInfo.getMedium_seat_price().equals(""))
                        {
                            medium_price =trainTicketPriceInfo.getMedium_seat_price();
                        }
                        if(!trainTicketPriceInfo.getLow_seat_price().equals(""))
                        {
                            low_price =trainTicketPriceInfo.getLow_seat_price();
                        }
                    }
                }
            }


        for(TrainTicketPriceInfo trainTicketPriceInfo :trainTicketPriceInfos)
        {

            if(trainTicketPriceInfo != null)
            {
                if(trainTicketPriceInfo.getTrain_number().substring(0,1).equals("G") ||trainTicketPriceInfo.getTrain_number().substring(0,1).equals("D"))
                {
                    if(trainTicketPriceInfo.getHigh_seat_price().equals(""))
                    {
                        trainTicketPriceInfo.setHigh_seat_price(high_price_GD);
                    }
                    if(trainTicketPriceInfo.getMedium_seat_price().equals(""))
                    {
                        trainTicketPriceInfo.setMedium_seat_price(medium_price_GD);
                    }
                    if(trainTicketPriceInfo.getLow_seat_price().equals(""))
                    {
                        trainTicketPriceInfo.setLow_seat_price(low_price_GD);
                    }

                }
                else
                {
                    if(trainTicketPriceInfo.getHigh_seat_price().equals(""))
                    {
                        trainTicketPriceInfo.setHigh_seat_price(high_price);
                    }
                    if(trainTicketPriceInfo.getMedium_seat_price().equals(""))
                    {
                        trainTicketPriceInfo.setMedium_seat_price(medium_price);
                    }
                    if(trainTicketPriceInfo.getLow_seat_price().equals(""))
                    {
                        trainTicketPriceInfo.setLow_seat_price(low_price);
                    }
                }
            }

        }


       if(trainTicketPriceInfos.size() != 0)
       {
           return new TrainTicketPriceQueryReturnData(1,trainTicketPriceInfos);
       }
       else if(trainTicketPriceInfos.size() == 0)
       {
           return new TrainTicketPriceQueryReturnData(404,trainTicketPriceInfos);
       }
       else
       {
           return new TrainTicketPriceQueryReturnData(405,trainTicketPriceInfos);
       }

    }


    @RequestMapping(value ="/queryTrainTicketNum",method = RequestMethod.GET)
    public TrainSeatQueryReturnData GetTrainTicketPrice (@RequestParam String datetime, String train_no, String start_no,String end_no,String train_number) {

        java.util.Date dt = new java.util.Date();
         java.text.SimpleDateFormat sdfs =
                new java.text.SimpleDateFormat("yyyy-MM-dd");
        String currentTime = sdfs.format(dt);


        if(datetime.compareTo(currentTime)<0)
        {
            return new TrainSeatQueryReturnData(404,null,null);
        }
        List<TrainSeatQuery> trainSeatQuerieList = trainTickerQueryService.queryTrainSeat(train_no,start_no,end_no,datetime);

        List<TrainSeatCount> trainSeatCountList  = trainTickerQueryService.querySeatCount(train_no);

        List<TrainRemainingSeats_GD> trainRemainingSeats_gds =  new ArrayList<>();

        List<TrainRemainingSeats> trainRemainingSeatsList =  new ArrayList<>();
            if(train_number.substring(0,1).equals("G") || train_number.substring(0,1).equals("D"))
            {
                for(TrainSeatCount trainSeatCount : trainSeatCountList)
                {
                    TrainRemainingSeats_GD trainRemainingSeats_gd = new TrainRemainingSeats_GD(trainSeatCount.getCarriage_no(),trainSeatCount.getSeat_type());
                    trainRemainingSeats_gds.add(trainRemainingSeats_gd);
                }
                for(TrainSeatQuery trainSeatQuery :trainSeatQuerieList)
                {
                    for(TrainRemainingSeats_GD trainRemainingSeats_gd :trainRemainingSeats_gds)
                    {
                        if(trainRemainingSeats_gd.getCarriage_no().equals(trainSeatQuery.getCarriage_no()))
                        {
                            trainRemainingSeats_gd.Count(Integer.parseInt(trainSeatQuery.getSeat_no()));
                        }
                    }
                }
            }
            else
            {
                for(TrainSeatCount trainSeatCount : trainSeatCountList)
                {
                    TrainRemainingSeats trainRemainingSeats = new TrainRemainingSeats(trainSeatCount.getCarriage_no(),trainSeatCount.getSeat_type());
                    trainRemainingSeatsList.add(trainRemainingSeats);
                }
                for(TrainSeatQuery trainSeatQuery :trainSeatQuerieList)
                {
                    for(TrainRemainingSeats trainRemainingSeats :trainRemainingSeatsList)
                    {
                        if(trainRemainingSeats.getCarriage_no().equals(trainSeatQuery.getCarriage_no()))
                        {
                            trainRemainingSeats.Count(Integer.parseInt(trainSeatQuery.getSeat_no()));
                        }
                    }
                }
            }



            return new TrainSeatQueryReturnData(1, trainRemainingSeatsList,trainRemainingSeats_gds);
    }

    }
