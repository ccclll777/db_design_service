package com.example.db_design_service.controller;


import com.example.db_design_service.bean.*;
import com.example.db_design_service.dao.TrainParkingStationDao;
import com.example.db_design_service.service.TrainInfoService;
import com.example.db_design_service.service.TrainParkingStationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * 有关列车信息查询的业务逻辑层
 */
@RestController
@RequestMapping("/train")
public class TrainInfoSelectController {
    private static final Logger logger = LoggerFactory.getLogger(TrainInfoSelectController.class);
    @Resource
    private TrainInfoService  trainInfoService;

    @Resource
    private TrainParkingStationService trainParkingStationService;

    /**
     * 查询所有列车信息
     * 对应前端的getTrainInfoData请求
     * @param offset
     * @param limit
     * @return
     */
    @RequestMapping(value ="/traininfo",method = RequestMethod.GET)
    public TrainInfoReturnData TrainInfo(Integer offset,Integer limit)
    {

        List<TrainInfo>  trainInfos = trainInfoService.selectAllTrainInfo(offset,limit);


        if(!trainInfos.isEmpty())
        {
            return new TrainInfoReturnData(1,trainInfos);
        }

        return new TrainInfoReturnData(404,trainInfos);
    }

    /**
     *
     * 根据车次查询列车信息
     *
     * 对应前端的SearchTrainInfoData请求
     * @param train_number
     * @return
     */
    @RequestMapping(value ="/searchtraininfo",method = RequestMethod.GET)
    public SearchTrainInfoReturnData SearchTrainInfo(String train_number)
    {

        TrainInfo trainInfo = trainInfoService.selectTrainInfo(train_number);
        if(!trainInfo.toString().equals(""))
        {
            return new SearchTrainInfoReturnData(1, trainInfo);
        }

            return new SearchTrainInfoReturnData(404,trainInfo);
        }

    /**
     *
     *根据车次查询列车的经停信息
     * 对应前端的 SearchTrainParkingInfo请求
     * @param train_number
     * @return
     */
    @RequestMapping(value ="/searchtrainparkingInfo",method = RequestMethod.GET)
    public TrainParkingInfoReturnData SearchTrainInfoList(String train_number)
    {
        logger.info(train_number);
        List<TrainParkingInfo> trainParkingInfos = trainParkingStationService.selectTrainParkingInfo(train_number);
        logger.info(String.valueOf(trainParkingInfos.size()));
        for(TrainParkingInfo trainParkingInfo :trainParkingInfos)
        {
            logger.info(trainParkingInfo.getStation_no());
        }
        return new TrainParkingInfoReturnData(1,trainParkingInfos);


    }

       @RequestMapping(value ="/updateTrainTypeStart",method = RequestMethod.GET)
    public RespBean updateTrainTypeStart(String train_no)
    {

        try
        {
            trainInfoService.updateTrainTypeStart(train_no);
            return new RespBean(1,"修改成功");
        }
        catch (Exception e)
        {
            return new RespBean(404,"修改失败");
        }
    }

    @RequestMapping(value ="/updateTrainTypeStop",method = RequestMethod.GET)
    public RespBean updateTrainTypeStop(String train_no)
    {

        try
        {
            trainInfoService.updateTrainTypeStop(train_no);
            return new RespBean(1,"修改成功");
        }
        catch (Exception e)
        {
            return new RespBean(404,"修改失败");
        }
    }

    @RequestMapping(value ="/selectSeatInfoByTrainNumber",method = RequestMethod.GET)
    public SeatInfoReturnData SelectSeatInfoByTrainNumber(String train_number)
    {

        try
        {

            return new SeatInfoReturnData(1, trainInfoService.SelectSeatInfoByTrainNumber(train_number));

        }
        catch (Exception e)
        {

            logger.info(e.getMessage());
            return new SeatInfoReturnData(404,null);

        }
    }


    @RequestMapping(value ="/deleteTrainSeat",method = RequestMethod.GET)
    public RespBean deleteTrainSeat(String train_no,String carriage_no)
    {
        try
        {

            trainInfoService.deleteTrainSeat(train_no,carriage_no);
            return new RespBean(1, "删除成功");

        }
        catch (Exception e)
        {

            logger.info(e.getMessage());
            return new RespBean(404,"删除失败");

        }

    }
    @RequestMapping(value ="/addTrainSeat",method = RequestMethod.GET)
    public RespBean addTrainSeat(String train_no,String carriage_no,String seat_type,String seat_count)
    {

        try
        {

           SeatInfo seatInfo = new SeatInfo(train_no,null,carriage_no,seat_type,Integer.parseInt(seat_count));
           trainInfoService.addTrainSeat(seatInfo);
            return new RespBean(1, "添加成功");

        }
        catch (Exception e)
        {

            logger.info(e.getMessage());
            return new RespBean(404,"添加失败");

        }
    }


    @RequestMapping(value ="/getAllTrainNumber",method = RequestMethod.GET)
    public GetAllTrainNumberListReturnData getAllTrainNumber()
    {
        try {

            List<String> trainNumberLists = trainInfoService.selectAllTrainNumber();
            List<TrainNumberData> trainNumberDatas = new ArrayList<>();
            for(int i = 0 ; i<trainNumberLists.size() ; i++)
            {

                TrainNumberData trainNumberData = new TrainNumberData(trainNumberLists.get(i),"111");
                trainNumberDatas.add(trainNumberData);
            }
            return new GetAllTrainNumberListReturnData(1,trainNumberDatas);
        }
       catch (Exception e)
       {
           logger.info(e.getMessage());
           return new GetAllTrainNumberListReturnData(404,null);

       }
    }

    @RequestMapping(value ="/getAllStationName",method = RequestMethod.GET)
    public GetAllTrainNumberListReturnData getAllStationName()
    {
        try {

            List<String> stationNameList = trainParkingStationService.selectAllStationName();
                    List<TrainNumberData> trainNumberDatas = new ArrayList<>();
            for(int i = 0 ; i<stationNameList.size() ; i++)
            {

                TrainNumberData trainNumberData = new TrainNumberData(stationNameList.get(i),"111");
                trainNumberDatas.add(trainNumberData);
            }
            return new GetAllTrainNumberListReturnData(1,trainNumberDatas);
        }
        catch (Exception e)
        {
            logger.info(e.getMessage());
            return new GetAllTrainNumberListReturnData(404,null);

        }
    }
    @RequestMapping(value ="/addTrainInfo",method = RequestMethod.POST)
    public RespBean UserLogin(@Valid @RequestBody Map<String,Object> request, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }
        String train_no = (String) request.get("train_no");
        String train_number = (String) request.get("train_number");
        String train_type = (String) request.get("train_type");
        String train_carriages = (String) request.get("train_carriages");
        String train_start_station = (String) request.get("train_start_station");
        String train_end_station = (String) request.get("train_end_station");
        String train_start_time = (String) request.get("train_start_time");
        String train_end_time = (String) request.get("train_end_time");
        String train_arrive_day = (String) request.get("train_arrive_day");
        String train_running_time = (String) request.get("train_running_time");
        String train_running_type = (String) request.get("train_running_type");

        try
        {
            TrainInfo trainInfo = new TrainInfo(train_no,train_number,train_type,train_carriages,train_start_station,train_end_station,train_start_time,train_end_time,train_arrive_day,train_running_time,train_running_type);
            trainInfoService.AddTrainInfo(trainInfo);
            return new RespBean(1,"插入成功");
        }
        catch (Exception e)
        {
            logger.info(e.getMessage());
            return new RespBean(403,"插入失败");
        }

    }


    @RequestMapping(value ="/addTrainStation",method = RequestMethod.POST)
    public RespBean addTrainStation(@Valid @RequestBody Map<String,Object> request, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }
        String train_no = (String) request.get("train_no");
        String train_number = (String) request.get("train_number");
        String station_no = (String) request.get("station_no");
        String station_name = (String) request.get("station_name");
        String arrive_time = (String) request.get("arrive_time");
        String start_time = (String) request.get("start_time");
        String running_time = (String) request.get("running_time");
        String arrive_day_str = (String) request.get("arrive_day_str");
        try
        {
            TrainParkingInfo trainParkingInfo = new TrainParkingInfo(station_no,station_name,train_number,start_time,arrive_time,running_time,arrive_day_str);
            trainInfoService.AddTrainStation(trainParkingInfo,train_no);
            return new RespBean(1,"插入成功");
        }catch (Exception e)
        {
            logger.info(e.getMessage());
            return new RespBean(403,"插入失败");
        }


    }




}
