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
import java.util.Iterator;
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


    /**
     *
     * 查询接续换乘路线
     * @param train_start_station
     * @param train_end_station
     */

    @RequestMapping(value ="/searchTransferSchedule",method = RequestMethod.GET)
    public TrainTransferScheduleReturnData GetTrainScheduleInfoList(@RequestParam String train_start_station, String train_end_station) {

       logger.info(train_start_station);
       logger.info(train_end_station);
       List<TrainTransferSchedule> trainTransferScheduleList = trainScheduleService.searchTransferSchedule(train_start_station,train_end_station);

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

        for(int i = 0 ; i<trainTransferScheduleList.size() ; i ++)
        {
            for(int j = 0 ; j <trainTransferScheduleList.size() - 1 - i ; j++)
            {
                int m  = getMin(trainTransferScheduleList.get(j).getStart_time_2()) -getMin(trainTransferScheduleList.get(j).getArrive_time_1());
                int n = getMin(trainTransferScheduleList.get(j+1).getStart_time_2()) -getMin(trainTransferScheduleList.get(j+1).getArrive_time_1());
                if(m>n)
                {
                    TrainTransferSchedule trainTransferSchedule = trainTransferScheduleList.get(j);
                    trainTransferScheduleList.set(j,trainTransferScheduleList.get(j+1));
                    trainTransferScheduleList.set(j+1,trainTransferSchedule);
                }
            }
        }
        for(TrainTransferSchedule trainTransferSchedule :trainTransferScheduleList)
        {
            logger.info(String.valueOf(getMin(trainTransferSchedule.getStart_time_2()) -getMin(trainTransferSchedule.getArrive_time_1())));
        }
            return new TrainTransferScheduleReturnData(1,trainTransferScheduleList);
    }

    public int getMin(String time)
    {
        String [] time2 = time.split(":");
        int Hour = Integer.parseInt(time2[0]);
        int Min = Integer.parseInt(time2[1]);
        int Min_result  = Hour *60 +Min;

        return Min_result;
    }
}
