package com.example.db_design_service.service;

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
    public  TrainTicketPriceInfo queryTicketPrice(String start_station , String end_station,String train_no)
    {
        return trainTicketQueryDao.queryTicketPrice(start_station,end_station,train_no);
    }
}
