package com.example.db_design_service.dao;

import com.example.db_design_service.bean.TrainTicketPriceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 * 车票查询的dao层
 *
 * 来根据各种信息查询车票的价格
 *
 * 以及是否还有余票
 *
 */
@Mapper


public interface TrainTicketQueryDao {

    /**
     *
     *
     * 根据列车编号 以及出发站 到达站 查询列车的车票价格
     *
     *
     * @param start_station
     * @param end_station
     * @param train_no
     * @return
     */
        @Select("select C.train_no as train_no,C.train_number as train_number ,C.station_name as start_station ,D.station_name as end_station , " +
                "                             C.station_no as start_no , D.station_no as  end_no," +
                "                             C.start_time as start_time , D.arrive_time as arrive_time," +
                "                                C.running_time as start_running_time ,D.running_time as end_running_time ," +
                "                        E.business_seat as high_seat_price , E.first_class_seats as medium_seat_price,E.second_class_seats as low_seat_price" +
                "                            from train_parking_station as C ,train_parking_station as D ,schedule_of_trains E" +
                "                              where C.train_no = #{train_no} and C.train_no = D.train_no and C.train_no = E.tarin_no and C.station_name = E.from_station and D.station_name = E.to_station" +
                "                and C.station_name =#{start_station} and D.station_name =#{end_station}" +
                "                                and C.train_no in (select A.train_no from " +
                "                train_parking_station as A ,train_parking_station as B" +
                "                            where  A.train_no = B.train_no and" +
                "                              A.station_name =#{start_station} and" +
                "                               B.station_name =#{end_station} " +
                "                         and A.station_no <B.station_no)")
    TrainTicketPriceInfo queryTicketPrice(@Param("start_station") String start_station , @Param("end_station") String end_station,@Param("train_no") String train_no);
}
