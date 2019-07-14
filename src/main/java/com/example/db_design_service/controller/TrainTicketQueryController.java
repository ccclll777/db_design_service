package com.example.db_design_service.controller;

import com.example.db_design_service.RedisUtils;
import com.example.db_design_service.bean.TrainScheduleInfo;
import com.example.db_design_service.bean.TrainScheduleReturnData;
import com.example.db_design_service.bean.TrainTicketPriceInfo;
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
    public void GetTrainScheduleInfo(@RequestParam String train_start_station, String train_end_station,String datetime) {

            logger.info(train_start_station);
            logger.info(train_end_station);
            logger.info(datetime);
            List<TrainScheduleInfo> trainScheduleInfos = trainScheduleService.searchTrainScheduleInfo(train_start_station,train_end_station);
            List<TrainTicketPriceInfo> trainTicketPriceInfos = new ArrayList<>();
            for(TrainScheduleInfo trainScheduleInfo :trainScheduleInfos)
            {
//                List<TrainTicketPriceInfo> temp = trainTickerQueryService.queryTicketPrice(train_start_station,train_end_station,trainScheduleInfo.getTrain_no());
////                for(TrainTicketPriceInfo trainTicketPriceInfo :temp)
////                {
////                    trainTicketPriceInfos.add(trainTicketPriceInfo);
////                }
                trainTicketPriceInfos.add(trainTickerQueryService.queryTicketPrice(train_start_station,train_end_station,trainScheduleInfo.getTrain_no()));
            }


            for(TrainTicketPriceInfo trainTicketPriceInfo :trainTicketPriceInfos)
            {
                logger.info(trainTicketPriceInfo.getLow_seat_price());
            }

    }
}
