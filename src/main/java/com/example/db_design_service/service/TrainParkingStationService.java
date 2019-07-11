package com.example.db_design_service.service;

import com.example.db_design_service.bean.TrainParkingInfo;
import com.example.db_design_service.dao.TrainParkingStationDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TrainParkingStationService {


    @Resource
    private TrainParkingStationDao trainParkingStationDao;

    public List<TrainParkingInfo> selectTrainParkingInfo(String train_number)
    {
           return trainParkingStationDao.findTrainParkingInfo(train_number);
    }
}
