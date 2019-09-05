package com.example.db_design_service.service;

import com.example.db_design_service.bean.SeatInfo;
import com.example.db_design_service.bean.TrainInfo;
import com.example.db_design_service.bean.TrainParkingInfo;
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

    public void updateTrainTypeStop(String train_no)
    {
        trainInfoDao.updateTrainTypeStop(train_no);
    }
    public void updateTrainTypeStart(String train_no)
    {
        trainInfoDao.updateTrainTypeStart(train_no);
    }

    public  List<SeatInfo> SelectSeatInfoByTrainNumber(String train_number)
    {
        return trainInfoDao.SelectSeatInfoByTrainNumber(train_number);
    }
    public void deleteTrainSeat(String train_no,String carriage_no)
    {
        trainInfoDao.deleteTrainSeat(train_no,carriage_no);
    }
    public void addTrainSeat(SeatInfo seatInfo)
    {
        trainInfoDao.addTrainSeat(seatInfo);
    }

    public  List<String> selectAllTrainNumber()
    {
        return trainInfoDao.selectAllTrainNumber();
    }

    public void AddTrainInfo(TrainInfo trainInfo)
    {
        trainInfoDao.AddTrainInfo(trainInfo);
    }
    public void AddTrainStation(TrainParkingInfo trainParkingInfo,String train_no)
    {

        trainInfoDao.AddTrainStation(trainParkingInfo,train_no);
    }
}
