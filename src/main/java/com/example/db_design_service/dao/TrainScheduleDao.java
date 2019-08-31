package com.example.db_design_service.dao;

import com.example.db_design_service.bean.TrainScheduleInfo;
import com.example.db_design_service.bean.TrainTransferSchedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 *
 * 列车时刻查询类  根据出发地和目的地查询符合条件的列车信息
 * 以及列车的经停信息
 */
@Mapper
public interface TrainScheduleDao {


    /**
     *
     *
     * 根据起始站和目的站查询符合条件的车次
     * @param start_station
     * @param end_station
     * @return
     */
    @Select("select C.train_no as train_no ,C.train_number as train_number ,\n" +
            " C.station_name as start_station ,D.station_name as end_station ,\n" +
            " C.station_no as start_no , D.station_no as  end_no  ,\n" +
            " C.start_time as start_time , D.arrive_time as arrive_time,\n" +
            " C.running_time as start_running_time ,D.running_time as end_running_time \n" +
            " from train_parking_station as C ,train_parking_station as D \n" +
            " where C.train_no = D.train_no \n" +
            " and C.station_name = #{start_station} and D.station_name = #{end_station}\n" +
            " and C.train_no in (select A.train_no from \n" +
            "train_parking_station as A ,train_parking_station as B \n" +
            "where  A.train_no = B.train_no and \n" +
            "A.station_name = #{start_station} and\n" +
            " B.station_name = #{end_station} \n" +
            " and A.station_no <B.station_no)")
    List<TrainScheduleInfo>  searchTrainSchedule(@Param("start_station") String start_station , @Param("end_station") String end_station);


    /**
     *
     *  根据始发站和目的站查询
     *  所有的经停站
     * @param train_no
     * @param start_no
     * @param end_no
     * @return
     */
    @Select("select A.train_no as train_no, A.train_number as train_number ,\n" +
            "A.station_name as start_station ,B.station_name as end_station , \n" +
            " A.station_no as start_no , B.station_no as  end_no  ,\n" +
            "  A.start_time as start_time , B.arrive_time as arrive_time,\n" +
            "   A.running_time as start_running_time ,B.running_time as end_running_time \n" +
            "    from train_parking_station as A ,train_parking_station as B \n" +
            "    where A.station_no between #{start_no} and #{end_no} \n" +
            "    and  B.station_no between #{start_no} and #{end_no} \n" +
            "    and A.train_no = #{train_no} \n" +
            "    and A.train_no = B.train_no \n" +
            "    and B.station_no = A.station_no +1 order by A.station_no ,B.station_no ")
    List<TrainScheduleInfo>  searchTrainScheduleList(@Param("train_no") String train_no,@Param("start_no") String start_no , @Param("end_no") String end_no);


    /**
     *
     * 根据 始发站 和终点站 查询换乘的车辆
     * @param start_station
     * @param end_station
     * @return
     */

        @Select("select A.train_no as train_no_1 ,A.train_number as train_number_1, D.train_no as train_no_2 , " +
                "D.train_number as train_number_2, A.station_no as start_station_no,A.station_name as start_station_name," +
                "B.station_no as transfer_station_no_1 , B.station_name as transfer_station_name ,C.station_no as transfer_station_no_2,A.start_time as start_time_1," +
                "B.arrive_time as arrive_time_1 , C.start_time as start_time_2 ,D.arrive_time as arrive_time_2," +
                "D.station_no as end_station_no, D.station_name as end_station_name, A.running_time as start_running_time_1," +
                "B.running_time as end_running_time_1 ,C.running_time as start_running_time_2, D.running_time as end_running_time_2 " +
                "from  train_parking_station as A , train_parking_station as B , train_parking_station as C ,train_parking_station as D " +
                "where A.station_name = #{start_station} and D.station_name = #{end_station} and " +
                "A.train_no = B.train_no and B.station_name = C.station_name " +
                "and C.train_no = D.train_no and B.train_no <> C.train_no   and " +
                "B.arrive_time < C.arrive_time and A.train_no in (select X.train_no from " +
                "train_parking_station as X ,train_parking_station as Y " +
                "where  X.train_no = Y.train_no and" +
                " X.station_name = #{start_station} and Y.station_name = B.station_name and X.station_no < Y.station_no) " +
                " and C.train_no in (select X.train_no from train_parking_station as X ,train_parking_station as Y " +
                " where  X.train_no = Y.train_no and X.station_name = C.station_name and Y.station_name =  #{end_station} and X.station_no < Y.station_no) ")
    List<TrainTransferSchedule> searchTransferSchedule(@Param("start_station") String start_station , @Param("end_station") String end_station);
//    @Select("select A.train_no as train_no_1 ,A.train_number as train_number_1, D.train_no as train_no_2 , " +
//            "D.train_number as train_number_2, A.station_no as start_station_no,A.station_name as start_station_name," +
//            "B.station_no as transfer_station_no_1 , B.station_name as transfer_station_name ,C.station_no as transfer_station_no_2,A.start_time as start_time_1," +
//            "B.arrive_time as arrive_time_1 , C.start_time as start_time_2 ,D.arrive_time as arrive_time_2," +
//            "D.station_no as end_station_no, D.station_name as end_station_name, A.running_time as start_running_time_1," +
//            "B.running_time as end_running_time_1 ,C.running_time as start_running_time_2, D.running_time as end_running_time_2 " +
//            "from  train_parking_station as A , train_parking_station as B , train_parking_station as C ,train_parking_station as D " +
//            "where A.station_name = #{start_station} and D.station_name = #{end_station} and " +
//            "A.train_no = B.train_no and B.station_name = C.station_name " +
//            "and C.train_no = D.train_no and B.train_no <> C.train_no   and " +
//            "B.arrive_time < C.arrive_time and A.station_no <B.station_no and C.station_no<D.station_no")
//    List<TrainTransferSchedule> searchTransferSchedule(@Param("start_station") String start_station , @Param("end_station") String end_station);

}
