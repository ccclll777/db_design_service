package com.example.db_design_service.service;


import com.example.db_design_service.bean.TrainSeatCount;
import com.example.db_design_service.bean.TrainSeatQuery;
import com.example.db_design_service.bean.TrainTicketPriceInfo;
import com.example.db_design_service.dao.TrainTicketQueryDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 *
 * 对应TrainTickerQueryDao
 *
 *
 */
@Service
public class TrainTickerQueryService {

    @Resource
    private TrainTicketQueryDao trainTicketQueryDao;


    /**
     *
     *根据出发地 目的地 列车号
     *
     * 查询列车票价
     * @param start_station
     * @param end_station
     * @param train_no
     * @return
     */
    public  TrainTicketPriceInfo queryTicketPrice_GD(String start_station , String end_station,String train_no)
    {
        return trainTicketQueryDao.queryTicketPrice_GD(start_station,end_station,train_no);
    }

    public  TrainTicketPriceInfo queryTicketPrice(String start_station , String end_station,String train_no)
    {
        return trainTicketQueryDao.queryTicketPrice(start_station,end_station,train_no);
    }

    /**
     *
     * 根据列车编号  列车起始站 和目的站 时间
     * 查询已经被预定的列车票数
     * @param train_no
     * @param start_no
     * @param end_no
     * @param datetime
     * @return
     */
    public List<TrainSeatQuery> queryTrainSeat(String train_no,String start_no,String end_no,String datetime)
    {
        return trainTicketQueryDao.querySeatOrder(train_no,start_no,end_no,datetime);
    }

    public List<TrainSeatCount> querySeatCount(String train_no)

    {
        return trainTicketQueryDao.QuerySeatCount(train_no);
    }

    public List<TrainSeatQuery> queryCarriageSeatQuery(String train_no, String carriage_no,String start_no,String end_no,String datetime)
    {
        return trainTicketQueryDao.QueryCarriageSeatQuery(train_no,carriage_no,start_no,end_no,datetime);
    }


    public List<TrainSeatCount> queryCarriageSeatCount(String train_no, String carriage_no)
    {
        return trainTicketQueryDao.QueryCarriageSeatCount(train_no,carriage_no);
    }

}
