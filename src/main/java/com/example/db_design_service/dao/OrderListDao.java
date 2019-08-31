package com.example.db_design_service.dao;


import com.example.db_design_service.bean.AllOrder;
import com.example.db_design_service.bean.GetAllNoTripData;
import com.example.db_design_service.bean.GetAllOrderList;
import com.example.db_design_service.bean.GetOrderList;
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


    @Select("select A.order_id as order_id,B.passenger_real_name as passenger_real_name ," +
            "A.passenger_phone_number as passenger_phone_number,A.passenger_id_number as passenger_id_number," +
            "A.carriage_no  as carriage_no, C.seat_type as seat_type,A.seat_no as seat_no" +
            " from order_list as A , passenger as B ,seat as C " +
            " where   A.train_no = C.train_no and A.carriage_no = C.carriage_no and A.passenger_phone_number = B.passenger_phone_number and A.order_id = #{order_id}")
    List<GetOrderList> GetOrderInfo(@Param("order_id") String order_id);


    @Select("select A.order_id as order_id,B.passenger_real_name as passenger_real_name ," +
            "A.passenger_phone_number as passenger_phone_number,A.passenger_id_number as passenger_id_number," +
            "A.carriage_no  as carriage_no, C.seat_type as seat_type,A.seat_no as seat_no" +
            " from order_list as A , passenger as B ,seat as C " +
            " where A.user_phone_number = #{user_phone_number} and left(train_start_date,10) = #{datetime} and A.train_no = #{train_no} and A.start_station_no = #{start_no} " +
            " and A.end_station_no = #{end_no} and A.train_no = C.train_no and A.carriage_no = C.carriage_no and A.passenger_phone_number = B.passenger_phone_number and A.order_status = '未支付' and A.passenger_phone_number = #{passenger_phone_number}")
    List<GetOrderList> GetOrderChagngeList(@Param("user_phone_number") String user_phone_number, @Param("datetime") String datetime,
                                    @Param("train_no") String train_no, @Param("start_no") String start_no, @Param("end_no") String end_no,@Param("passenger_phone_number") String passenger_phone_number);

    @Select("select order_money from order_list where order_id = #{order_id}")
    String GetOrderMoney(@Param("order_id") String order_id);


    @Select("select A.order_id as order_id , D.passenger_real_name as passenger_real_name,C.train_number as train_number ," +
            "A.start_station_name as start_station_name ,A.end_station_name as end_station_name," +
            "A.carriage_no as carriage_no, B.seat_type as seat_type," +
            "A.seat_no as seat_no,  A.train_start_date as start_date," +
            "C.start_time as start_time , A.order_status as order_status," +
            "A.passenger_phone_number as passenger_phone_number," +
            "A.passenger_id_number as passenger_id_number ," +
            "A.order_money as order_money " +
            "from order_list as A ,seat as B , train_parking_station as C , passenger as D " +
            "where  " +
            " A.train_no = B.train_no " +
            "and A.carriage_no = B.carriage_no " +
            "and A.train_no = C.train_no " +
            "and A.passenger_phone_number = D.passenger_phone_number " +
            "and C.station_name  = A.start_station_name " +
            " order by A.order_create_time")
    List<GetAllOrderList> GetAllOrder();

    @Update("update order_list set order_status = '已出行' where order_status = '未出行' and order_id = #{order_id} ")
    void UpdatePayOrderStatus(@Param("order_id") String order_id);


    @Update("update order_list set order_status = '未完成支付' where order_status = '未支付'and order_id = #{order_id} ")
    void UpdateNoPayOrderStatus(@Param("order_id") int order_id);

    @Select("select order_id,train_no,start_station_no from order_list where order_status = '未出行' and  to_days(train_start_date) = to_days(now())")
    List<GetAllNoTripData>  GetAllNoTripOrder();

    @Select("select * from order_list where order_status = '未支付' and  to_days(order_create_time) = to_days(now())")
    List<AllOrder>  GetAllNoPayOrder();


    @Select("select * from order_list where order_status = '未出行' and  passenger_phone_number = #{passenger_phone_number}")
     List<AllOrder>  GetAllNoTripOrderByPassenger(@Param("passenger_phone_number") String passenger_phone_number);

}
