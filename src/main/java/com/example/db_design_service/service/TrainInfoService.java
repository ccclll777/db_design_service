package com.example.db_design_service.service;

import com.example.db_design_service.bean.TrainInfo;
import com.example.db_design_service.dao.TrainInfoDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TrainInfoService {

    @Resource
    private TrainInfoDao trainInfoDao;

    public List<TrainInfo> selectAllTrainInfo()
    {
        return trainInfoDao.findAllTrainInfo();
    }
    public List<TrainInfo> selectAllTrainInfo(int offset,int limit)
    {
        return trainInfoDao.findTrainInfoByLimit(offset,limit);
    }
    public TrainInfo selectTrainInfo(String train_number)
    {
        return trainInfoDao.findTrainInfo(train_number);
    }

}
