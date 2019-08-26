package com.example.db_design_service.service;

import com.example.db_design_service.bean.TrainParkingInfo;
import com.example.db_design_service.dao.TrainParkingStationDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 *
 * 对应TrainParkingStationDao层
 */
@Service
public class TrainParkingStationService {


    @Resource
    private TrainParkingStationDao trainParkingStationDao;


    /**
     * 根据列车号  查询列车经停信息
     * @param train_number
     * @return
     */
    public List<TrainParkingInfo> selectTrainParkingInfo(String train_number)
    {
           return trainParkingStationDao.findTrainParkingInfo(train_number);
    }

    public  String searchStation_name(String train_no,String station_no)
    {
        return trainParkingStationDao.SearchStation_name(train_no,station_no);
    }
    public  List<String> selectAllStationName()
    {
        return trainParkingStationDao.selectAllStationName();
    }
}
