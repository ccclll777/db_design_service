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

/**
 *
 * 列车时刻表查询的业务处理逻辑
 *
 *
 */
@RestController
@RequestMapping("/trainSchedule")
public class TrainScheduleController {

    @Resource
    private TrainScheduleService trainScheduleService;
    @Resource
    private RedisUtils redisUtils;
    private static final Logger logger = LoggerFactory.getLogger(TrainInfoSelectController.class);

    /**
     *
     * 根据起始站 目的站  查询符合条件的列车信息
     *
     * 对应前端的searchTrainSchedule请求
     * @param train_start_station
     * @param train_end_station
     * @return
     */
    @RequestMapping(value ="/searchTrainSchedule",method = RequestMethod.GET)
    public TrainScheduleReturnData GetTrainScheduleInfo(@RequestParam String train_start_station, String train_end_station) {

        List<TrainScheduleInfo> trainScheduleInfos = trainScheduleService.searchTrainScheduleInfo(train_start_station,train_end_station);
        return new TrainScheduleReturnData(1,trainScheduleInfos);

    }


    /**
     * 返回列车具体的经停信息
     *
     * 对应前端的getTrainScheduleList请求
     * @param train_start_station_no
     * @param train_end_station_no
     * @param train_no
     * @return
     */
    @RequestMapping(value ="/getTrainScheduleList",method = RequestMethod.GET)
    public TrainScheduleReturnData GetTrainScheduleInfoList(@RequestParam String train_start_station_no, String  train_end_station_no, String train_no) {

        List<TrainScheduleInfo> trainScheduleInfos = trainScheduleService.searchTrainScheduleInfoList(train_no,train_start_station_no,train_end_station_no);
        return new TrainScheduleReturnData(1,trainScheduleInfos);
    }
}
