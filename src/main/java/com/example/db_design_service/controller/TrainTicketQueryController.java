package com.example.db_design_service.controller;

import com.example.db_design_service.RedisUtils;
import com.example.db_design_service.bean.*;
import com.example.db_design_service.service.TrainScheduleService;
import com.example.db_design_service.service.TrainTickerQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

        java.util.Date dt2 = new java.util.Date();
        java.text.SimpleDateFormat sdfs2 =
                new java.text.SimpleDateFormat("HH:mm:ss");
        String currentTime2 = sdfs2.format(dt2);


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

        if(datetime.compareTo(currentTime) == 0)
        {

            Iterator<TrainTicketPriceInfo> iterator = trainTicketPriceInfos.iterator();

            while (iterator.hasNext())
            {
                TrainTicketPriceInfo trainTicketPriceInfo = iterator.next();
               if(trainTicketPriceInfo.getStart_time().compareTo(currentTime2)<0 )
               {
                   iterator.remove();
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

        logger.info("queryTrainTicketNum");
        java.util.Date dt = new java.util.Date();
         java.text.SimpleDateFormat sdfs =
                new java.text.SimpleDateFormat("yyyy-MM-dd");
        String currentTime = sdfs.format(dt);


        if(datetime.compareTo(currentTime)<0)
        {
            return new TrainSeatQueryReturnData(404,null,null);
        }
        List<TrainSeatQuery> trainSeatQueriesList = trainTickerQueryService.queryTrainSeat(train_no,start_no,end_no,datetime);
        List<TrainSeatCount> trainSeatCountList  = trainTickerQueryService.querySeatCount(train_no);

        List<TrainRemainingSeats_GD> trainRemainingSeats_gds =  new ArrayList<>();

        List<TrainRemainingSeats> trainRemainingSeatsList =  new ArrayList<>();
        logger.info("41412412412");
        logger.info(train_number.substring(0,1));
            if(train_number.substring(0,1).equals("G") || train_number.substring(0,1).equals("D"))
            {
                logger.info("777777");
                for(TrainSeatCount trainSeatCount : trainSeatCountList)
                {
                    TrainRemainingSeats_GD trainRemainingSeats_gd = new TrainRemainingSeats_GD(trainSeatCount.getCarriage_no(),trainSeatCount.getSeat_type());
                    trainRemainingSeats_gds.add(trainRemainingSeats_gd);
                    logger.info("88888888");
                    logger.info(String.valueOf(trainSeatQueriesList.size()));
                    logger.info(String.valueOf(trainRemainingSeats_gds.size()));
                }
                for(TrainSeatQuery trainSeatQuery :trainSeatQueriesList)
                {
                    for(TrainRemainingSeats_GD trainRemainingSeats_gd :trainRemainingSeats_gds)
                    {
                        logger.info(trainRemainingSeats_gd.getCarriage_no() + "    "+ trainSeatQuery.getCarriage_no());
                        if(trainRemainingSeats_gd.getCarriage_no().equals(trainSeatQuery.getCarriage_no()))
                        {
                            trainRemainingSeats_gd.Count(Integer.parseInt(trainSeatQuery.getSeat_no()));
                            logger.info(trainSeatQuery.getSeat_no());
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
                for(TrainSeatQuery trainSeatQuery :trainSeatQueriesList)
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

    @RequestMapping(value ="/queryTrainTransferTicket",method = RequestMethod.GET)
   public TrainTransferTicketPriceReturnData GetTrainTransferScheduleInfo(@RequestParam String train_start_station, String train_end_station, String datetime)
    {
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdfs =
                new java.text.SimpleDateFormat("yyyy-MM-dd");
        String currentTime = sdfs.format(dt);
        if(datetime.compareTo(currentTime)<0)
        {
            return new TrainTransferTicketPriceReturnData(406,null);
        }

        List<TrainTransferSchedule>  trainTransferScheduleList = trainScheduleService.searchTransferSchedule(train_start_station,train_end_station);
        List<TrainTransferTicketPriceInfo> trainTransferTicketPriceInfoList = new ArrayList<>();

        Iterator<TrainTransferSchedule> iterator = trainTransferScheduleList.iterator();

        while (iterator.hasNext())
        {
            TrainTransferSchedule trainTransferSchedule = iterator.next();
            int j =  getMin(trainTransferSchedule.getStart_time_2()) -getMin(trainTransferSchedule.getArrive_time_1());
            if(j> 150 || j<30)
            {
                iterator.remove();
            }
        }

        for(TrainTransferSchedule trainTransferSchedule:trainTransferScheduleList)
        {
            TrainTicketPriceInfo temp1 ,temp2;
            if(trainTransferSchedule.getTrain_number_1().substring(0,1).equals("G") ||trainTransferSchedule.getTrain_number_1().substring(0,1).equals("D")  )
            {
                temp1 = trainTickerQueryService.queryTicketPrice_GD(trainTransferSchedule.getStart_station_name(),trainTransferSchedule.getTransfer_station_name(),trainTransferSchedule.getTrain_no_1());
            }
            else
            {
                 temp1 = trainTickerQueryService.queryTicketPrice(trainTransferSchedule.getStart_station_name(),trainTransferSchedule.getTransfer_station_name(),trainTransferSchedule.getTrain_no_1());

            }
            if(trainTransferSchedule.getTrain_number_2().substring(0,1).equals("G") ||trainTransferSchedule.getTrain_number_2().substring(0,1).equals("D")  )
            {
                 temp2 = trainTickerQueryService.queryTicketPrice_GD(trainTransferSchedule.getTransfer_station_name(),trainTransferSchedule.getEnd_station_name(),trainTransferSchedule.getTrain_no_2());
            }
            else
            {
                temp2 = trainTickerQueryService.queryTicketPrice(trainTransferSchedule.getTransfer_station_name(),trainTransferSchedule.getEnd_station_name(),trainTransferSchedule.getTrain_no_2());
            }

                if(temp1 !=null && temp2 !=null )
                {
                    TrainTransferTicketPriceInfo trainTransferTicketPriceInfo = new TrainTransferTicketPriceInfo(trainTransferSchedule.getTrain_no_1(),trainTransferSchedule.getTrain_number_1(),trainTransferSchedule.getTrain_no_2(),trainTransferSchedule.getTrain_number_2(),
                            trainTransferSchedule.getStart_station_no(),trainTransferSchedule.getStart_station_name(),trainTransferSchedule.getTransfer_station_no_1(),trainTransferSchedule.getTransfer_station_name(),
                            trainTransferSchedule.getStart_time_1(),trainTransferSchedule.getArrive_time_1(),trainTransferSchedule.getStart_time_2(),trainTransferSchedule.getArrive_time_2(),
                            trainTransferSchedule.getEnd_station_no(),trainTransferSchedule.getEnd_station_name(),trainTransferSchedule.getStart_running_time_1(),trainTransferSchedule.getEnd_running_time_1(),
                            trainTransferSchedule.getStart_running_time_2(),trainTransferSchedule.getEnd_running_time_2(),trainTransferSchedule.getTransfer_station_no_2(),temp1.getHigh_seat_price(),
                            temp1.getMedium_seat_price(),temp1.getLow_seat_price(),temp2.getHigh_seat_price(),temp2.getMedium_seat_price(),temp2.getLow_seat_price());
                    trainTransferTicketPriceInfoList.add(trainTransferTicketPriceInfo);
                }


        }


        for (int i = 0; i < trainTransferTicketPriceInfoList.size(); i++) {
            if (trainTransferTicketPriceInfoList.get(i) == null || trainTransferTicketPriceInfoList.contains(null)) {
                trainTransferTicketPriceInfoList.remove(null);
            }
        }
        String high_price_GD = null;
        String medium_price_GD = null;
        String low_price_GD = null;
        String high_price  = null;
        String medium_price = null;
        String low_price = null;
        String high_price_GD_2 = null;
        String medium_price_GD_2 = null;
        String low_price_GD_2 = null;
        String high_price_2  = null;
        String medium_price_2 = null;
        String low_price_2 = null;
        for(TrainTransferTicketPriceInfo trainTransferTicketPriceInfo :trainTransferTicketPriceInfoList)
        {
            if(trainTransferTicketPriceInfo != null)
            {
                if(trainTransferTicketPriceInfo.getTrain_number_1().substring(0,1).equals("G") ||trainTransferTicketPriceInfo.getTrain_number_1().substring(0,1).equals("D"))
                {
                    if(!trainTransferTicketPriceInfo.getHigh_seat_price_1().equals(""))
                    {
                        high_price_GD =trainTransferTicketPriceInfo.getHigh_seat_price_1();
                    }
                    if(!trainTransferTicketPriceInfo.getMedium_seat_price_1().equals(""))
                    {
                        medium_price_GD =trainTransferTicketPriceInfo.getMedium_seat_price_1();
                    }
                    if(!trainTransferTicketPriceInfo.getLow_seat_price_1().equals(""))
                    {
                        low_price_GD =trainTransferTicketPriceInfo.getLow_seat_price_1();
                    }

                }
                else
                {
                    if(!trainTransferTicketPriceInfo.getHigh_seat_price_1().equals(""))
                    {
                        high_price =trainTransferTicketPriceInfo.getHigh_seat_price_1();
                    }
                    if(!trainTransferTicketPriceInfo.getMedium_seat_price_1().equals(""))
                    {
                        medium_price =trainTransferTicketPriceInfo.getMedium_seat_price_1();
                    }
                    if(!trainTransferTicketPriceInfo.getLow_seat_price_1().equals(""))
                    {
                        low_price =trainTransferTicketPriceInfo.getLow_seat_price_1();
                    }
                }
                if(trainTransferTicketPriceInfo.getTrain_number_2().substring(0,1).equals("G") ||trainTransferTicketPriceInfo.getTrain_number_2().substring(0,1).equals("D"))
                {
                    if(!trainTransferTicketPriceInfo.getHigh_seat_price_2().equals(""))
                    {
                        high_price_GD_2 =trainTransferTicketPriceInfo.getHigh_seat_price_2();
                    }
                    if(!trainTransferTicketPriceInfo.getMedium_seat_price_2().equals(""))
                    {
                        medium_price_GD_2 =trainTransferTicketPriceInfo.getMedium_seat_price_2();
                    }
                    if(!trainTransferTicketPriceInfo.getLow_seat_price_2().equals(""))
                    {
                        low_price_GD_2 =trainTransferTicketPriceInfo.getLow_seat_price_2();
                    }

                }
                else
                {
                    if(!trainTransferTicketPriceInfo.getHigh_seat_price_2().equals(""))
                    {
                        high_price_2 =trainTransferTicketPriceInfo.getHigh_seat_price_2();
                    }
                    if(!trainTransferTicketPriceInfo.getMedium_seat_price_2().equals(""))
                    {
                        medium_price_2 =trainTransferTicketPriceInfo.getMedium_seat_price_2();
                    }
                    if(!trainTransferTicketPriceInfo.getLow_seat_price_2().equals(""))
                    {
                        low_price_2 =trainTransferTicketPriceInfo.getLow_seat_price_2();
                    }
                }
            }
        }

        for(TrainTransferTicketPriceInfo trainTransferTicketPriceInfo :trainTransferTicketPriceInfoList)
        {

            if(trainTransferTicketPriceInfo != null)
            {
                if(trainTransferTicketPriceInfo.getTrain_number_1().substring(0,1).equals("G") ||trainTransferTicketPriceInfo.getTrain_number_1().substring(0,1).equals("D"))
                {
                    if(trainTransferTicketPriceInfo.getHigh_seat_price_1().equals(""))
                    {
                        trainTransferTicketPriceInfo.setHigh_seat_price_1(high_price_GD);
                    }
                    if(trainTransferTicketPriceInfo.getMedium_seat_price_1().equals(""))
                    {
                        trainTransferTicketPriceInfo.setMedium_seat_price_1(medium_price_GD);
                    }
                    if(trainTransferTicketPriceInfo.getLow_seat_price_1().equals(""))
                    {
                        trainTransferTicketPriceInfo.setLow_seat_price_1(low_price_GD);
                    }

                }
                else
                {
                    if(trainTransferTicketPriceInfo.getHigh_seat_price_1().equals(""))
                    {
                        trainTransferTicketPriceInfo.setHigh_seat_price_1(high_price);
                    }
                    if(trainTransferTicketPriceInfo.getMedium_seat_price_1().equals(""))
                    {
                        trainTransferTicketPriceInfo.setMedium_seat_price_1(medium_price);
                    }
                    if(trainTransferTicketPriceInfo.getLow_seat_price_1().equals(""))
                    {
                        trainTransferTicketPriceInfo.setLow_seat_price_1(low_price);
                    }
                }

                if(trainTransferTicketPriceInfo.getTrain_number_2().substring(0,1).equals("G") ||trainTransferTicketPriceInfo.getTrain_number_2().substring(0,1).equals("D"))
                {
                    if(trainTransferTicketPriceInfo.getHigh_seat_price_2().equals(""))
                    {
                        trainTransferTicketPriceInfo.setHigh_seat_price_2(high_price_GD_2);
                    }
                    if(trainTransferTicketPriceInfo.getMedium_seat_price_2().equals(""))
                    {
                        trainTransferTicketPriceInfo.setMedium_seat_price_2(medium_price_GD_2);
                    }
                    if(trainTransferTicketPriceInfo.getLow_seat_price_2().equals(""))
                    {
                        trainTransferTicketPriceInfo.setLow_seat_price_2(low_price_GD_2);
                    }

                }
                else
                {
                    if(trainTransferTicketPriceInfo.getHigh_seat_price_2().equals(""))
                    {
                        trainTransferTicketPriceInfo.setHigh_seat_price_2(high_price_2);
                    }
                    if(trainTransferTicketPriceInfo.getMedium_seat_price_2().equals(""))
                    {
                        trainTransferTicketPriceInfo.setMedium_seat_price_2(medium_price_2);
                    }
                    if(trainTransferTicketPriceInfo.getLow_seat_price_2().equals(""))
                    {
                        trainTransferTicketPriceInfo.setLow_seat_price_2(low_price_2);
                    }
                }
            }

        }
        if(trainTransferTicketPriceInfoList.size() != 0)
        {
            return new TrainTransferTicketPriceReturnData(1,trainTransferTicketPriceInfoList);
        }
        else if(trainTransferTicketPriceInfoList.size() == 0)
        {
            return new TrainTransferTicketPriceReturnData(404,trainTransferTicketPriceInfoList);
        }
        else
        {
            return new TrainTransferTicketPriceReturnData(405,trainTransferTicketPriceInfoList);
        }
//


    }
    public int getMin(String time)
    {
        String [] time2 = time.split(":");
        int Hour = Integer.parseInt(time2[0]);
        int Min = Integer.parseInt(time2[1]);
        int Min_result  = Hour *60 +Min;

        return Min_result;
    }
    @RequestMapping(value ="/queryTransferTrainTicketNum",method = RequestMethod.POST)
    public  TrainTransferSeatCountReturnData queryTransferTrainTicketNum(@Valid @RequestBody Map<String,Object> request, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdfs =
                new java.text.SimpleDateFormat("yyyy-MM-dd");
        String currentTime = sdfs.format(dt);



        String datetime = (String) request.get("datetime");
        String train_no_1 = (String) request.get("train_no_1");
        String start_station_no = (String) request.get("start_station_no");
        String transfer_station_no_1 = (String) request.get("transfer_station_no_1");
        String train_number_1 = (String) request.get("train_number_1");
        String train_no_2 = (String) request.get("train_no_2");
        String train_number_2 = (String) request.get("train_number_2");
        String transfer_station_no_2 = (String) request.get("transfer_station_no_2");
        String end_station_no = (String) request.get("end_station_no");
        if(datetime.compareTo(currentTime)<0)
        {
            return new TrainTransferSeatCountReturnData(404,null);
        }
        List<TrainSeatQuery> trainSeatQuerieList_1 = trainTickerQueryService.queryTrainSeat(train_no_1,start_station_no,transfer_station_no_1,datetime);

        List<TrainSeatCount> trainSeatCountList_1  = trainTickerQueryService.querySeatCount(train_no_1);
        List<TrainSeatQuery> trainSeatQuerieList_2 = trainTickerQueryService.queryTrainSeat(train_no_2,transfer_station_no_2,end_station_no,datetime);

        List<TrainSeatCount> trainSeatCountList_2  = trainTickerQueryService.querySeatCount(train_no_2);

        List<TrainTransferSeatCount> trainTransferSeatCountList = new ArrayList<>();

        for(TrainSeatCount trainSeatCount :trainSeatCountList_1)
        {
            TrainTransferSeatCount trainTransferSeatCount = new TrainTransferSeatCount(train_no_1,trainSeatCount.getCarriage_no(),trainSeatCount.getSeat_type(),trainSeatCount.getSeat_count(),train_number_1);
            trainTransferSeatCountList.add(trainTransferSeatCount);
        }

        for(TrainSeatCount trainSeatCount :trainSeatCountList_2)
        {
            TrainTransferSeatCount trainTransferSeatCount = new TrainTransferSeatCount(train_no_2,trainSeatCount.getCarriage_no(),trainSeatCount.getSeat_type(),trainSeatCount.getSeat_count(),train_number_2);
            trainTransferSeatCountList.add(trainTransferSeatCount);
        }

        for(TrainTransferSeatCount trainTransferSeatCount :trainTransferSeatCountList)
        {
            for(TrainSeatQuery trainSeatQuery:trainSeatQuerieList_1)

            {
                    if(trainTransferSeatCount.getCarriage_no().equals(trainSeatQuery.getCarriage_no()) &&trainTransferSeatCount.getTrain_no().equals(trainSeatQuery.getTrain_no()))
                    {
                        trainTransferSeatCount.count();
                    }
            }
            for(TrainSeatQuery trainSeatQuery:trainSeatQuerieList_2)

            {
                if(trainTransferSeatCount.getCarriage_no().equals(trainSeatQuery.getCarriage_no()) &&trainTransferSeatCount.getTrain_no().equals(trainSeatQuery.getTrain_no()))
                {
                    trainTransferSeatCount.count();
                }
            }
        }
            return  new TrainTransferSeatCountReturnData(1,trainTransferSeatCountList);
    }

    }
