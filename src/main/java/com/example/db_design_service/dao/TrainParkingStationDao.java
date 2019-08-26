package com.example.db_design_service.dao;

import com.example.db_design_service.bean.TrainInfo;
import com.example.db_design_service.bean.TrainParkingInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 * 查询列车的时刻表
 */
@Mapper
public interface TrainParkingStationDao {


    /**
     *
     * 根据车次返回列车的时刻表
     * @param train_number
     * @return
     */
    @Select("select  DISTINCT b.station_no,b.station_name,  b.train_number, b.start_time, b.arrive_time, b.running_time,b.arrive_day_str from train_parking_station as a ,train_parking_station as b where a.train_number = #{train_number} and a.train_no = b.train_no order by b.station_no ")
     List<TrainParkingInfo> findTrainParkingInfo(@Param("train_number") String train_number);


    @Select("select station_name from train_parking_station where train_no = #{train_no} and station_no = #{station_no}")
    String SearchStation_name(@Param("train_no") String train_no, @Param("station_no") String station_no);

    @Select("select DISTINCT station_name from train_parking_station")
    List<String> selectAllStationName();

}
