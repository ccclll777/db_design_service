package com.example.db_design_service.dao;

import com.example.db_design_service.bean.TrainInfo;
import com.example.db_design_service.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.swing.text.TabableView;
import java.util.List;
@Mapper
public interface TrainInfoDao {

    @Select("SELECT * FROM train_info")
    List<TrainInfo> findAllTrainInfo();

    @Select("SELECT * FROM train_info where train_number = #{train_number}")
    TrainInfo findTrainInfo(@Param("train_number") String train_number);

}
