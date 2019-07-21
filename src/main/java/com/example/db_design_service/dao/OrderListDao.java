package com.example.db_design_service.dao;


import com.example.db_design_service.bean.GetAllOrderList;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderListDao {


    @Select("select A.order_id as order_id , D.passenger_real_name as passenger_real_name,C.train_number as train_number ," +
            "A.start_station_name as start_station_name ,A.end_station_name as end_station_name," +
            "A.carriage_no as carriage_no, B.seat_type as seat_type," +
            "A.seat_no as seat_no,  A.train_start_date as start_date," +
            "C.start_time as start_time , A.order_status as order_status," +
            "A.passenger_phone_number as passenger_phone_number," +
            "A.passenger_id_number as passenger_id_number ," +
            "A.order_money as order_money  " +
            "from order_list as A ,seat as B , train_parking_station as C , passenger as D " +
            "where A.user_phone_number = #{user_phone_number} " +
            "and A.train_no = B.train_no " +
            "and A.carriage_no = B.carriage_no " +
            "and A.train_no = C.train_no " +
            "and A.passenger_phone_number = D.passenger_phone_number " +
            "and C.station_name  = A.start_station_name " +
            " order by A.order_create_time")
    List<GetAllOrderList> GetAllOrderList(@Param("user_phone_number") String user_phone_number);

    @Select("select A.order_id as order_id , D.passenger_real_name as passenger_real_name,C.train_number as train_number ," +
            "A.start_station_name as start_station_name ,A.end_station_name as end_station_name," +
            "A.carriage_no as carriage_no, B.seat_type as seat_type," +
            "A.seat_no as seat_no,  A.train_start_date as start_date," +
            "C.start_time as start_time , A.order_status as order_status," +
            "A.passenger_phone_number as passenger_phone_number," +
            "A.passenger_id_number as passenger_id_number ," +
            "A.order_money as order_money  " +
            "from order_list as A ,seat as B , train_parking_station as C , passenger as D " +
            "where A.user_phone_number = #{user_phone_number} " +
            "and A.train_no = B.train_no " +
            "and A.carriage_no = B.carriage_no " +
            "and A.train_no = C.train_no " +
            "and A.passenger_phone_number = D.passenger_phone_number " +
            "and C.station_name  = A.start_station_name and A.order_status = '未出行' " +
            " order by A.order_create_time")
    List<GetAllOrderList> GetNotripOrderList(@Param("user_phone_number") String user_phone_number);

    @Select("select A.order_id as order_id , D.passenger_real_name as passenger_real_name,C.train_number as train_number ," +
            "A.start_station_name as start_station_name ,A.end_station_name as end_station_name," +
            "A.carriage_no as carriage_no, B.seat_type as seat_type," +
            "A.seat_no as seat_no,  A.train_start_date as start_date," +
            "C.start_time as start_time , A.order_status as order_status," +
            "A.passenger_phone_number as passenger_phone_number," +
            "A.passenger_id_number as passenger_id_number ," +
            "A.order_money as order_money  " +
            "from order_list as A ,seat as B , train_parking_station as C , passenger as D " +
            "where A.user_phone_number = #{user_phone_number} " +
            "and A.train_no = B.train_no " +
            "and A.carriage_no = B.carriage_no " +
            "and A.train_no = C.train_no " +
            "and A.passenger_phone_number = D.passenger_phone_number " +
            "and C.station_name  = A.start_station_name and A.order_status = '未支付' " +
            " order by A.order_create_time")
    List<GetAllOrderList> GetNopayOrderList(@Param("user_phone_number") String user_phone_number);


    @Update("update  order_list set order_status = '已退票' where order_id = #{order_id} and user_phone_number = #{user_phone_number}")
    void RefundTicket (@Param("user_phone_number") String user_phone_number ,@Param("order_id") String order_id);


    @Update("update  order_list set order_status = '已改签' where order_id = #{order_id} and passenger_phone_number = #{passenger_phone_number}")
    void ChangeTicket (@Param("passenger_phone_number") String passenger_phone_number ,@Param("order_id") String order_id);

}
