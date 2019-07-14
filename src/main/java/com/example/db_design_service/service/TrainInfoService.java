package com.example.db_design_service.service;

import com.example.db_design_service.bean.TrainInfo;
import com.example.db_design_service.dao.TrainInfoDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *对应TrainInfoDao
 *
 *
 */
@Service
public class TrainInfoService {

    @Resource
    private TrainInfoDao trainInfoDao;

    /**
     *
     * 查询所有列车信息
     * @return
     */
    public List<TrainInfo> selectAllTrainInfo()
    {
        return trainInfoDao.findAllTrainInfo();
    }

    /**
     *
     * 分页查询
     * @param offset
     * @param limit
     * @return
     */
    public List<TrainInfo> selectAllTrainInfo(int offset,int limit)
    {
        return trainInfoDao.findTrainInfoByLimit(offset,limit);
    }

    /**
     *
     * 查询对应车次的列车信息
     * @param train_number
     * @return
     */
    public TrainInfo selectTrainInfo(String train_number)
    {
        return trainInfoDao.findTrainInfo(train_number);
    }

}
