package com.example.db_design_service.controller;

import com.example.db_design_service.RedisUtils;
import com.example.db_design_service.bean.*;
import com.example.db_design_service.service.TrainScheduleService;
import com.example.db_design_service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/trainSchedule")
public class TrainScheduleController {

    @Resource
    private TrainScheduleService trainScheduleService;
    @Resource
    private RedisUtils redisUtils;
    private static final Logger logger = LoggerFactory.getLogger(TrainInfoSelectController.class);
    @RequestMapping(value ="/searchTrainSchedule",method = RequestMethod.GET)
    public TrainScheduleReturnData GetTrainScheduleInfo(@RequestParam String train_start_station, String train_end_station, String date) {

        List<TrainScheduleInfo> trainScheduleInfos = trainScheduleService.searchTrainScheduleInfo(train_start_station,train_end_station);
        return new TrainScheduleReturnData(1,trainScheduleInfos);

    }


    @RequestMapping(value ="/getTrainScheduleList",method = RequestMethod.GET)
    public TrainScheduleReturnData GetTrainScheduleInfoList(@RequestParam String train_start_station_no, String  train_end_station_no, String train_no) {


        logger.info(train_start_station_no);
        logger.info(train_end_station_no);
        logger.info(train_no);
        List<TrainScheduleInfo> trainScheduleInfos = trainScheduleService.searchTrainScheduleInfoList(train_no,train_start_station_no,train_end_station_no);
        return new TrainScheduleReturnData(1,trainScheduleInfos);
    }
}
