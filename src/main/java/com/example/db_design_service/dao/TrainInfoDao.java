package com.example.db_design_service.dao;

import com.example.db_design_service.bean.TrainInfo;
import com.example.db_design_service.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.swing.text.TabableView;
import java.util.List;
/**
 *
 * 查询所有列车信息
 * 或者查询某辆列车信息
 */
@Mapper
public interface TrainInfoDao {

    /**
     *
     * 查询所有列车信息
     * @return
     */
    @Select("SELECT * FROM train_info LIMIT 100")
    List<TrainInfo> findAllTrainInfo();

    /**
     *
     * 前端列车信息分页查询
     * @param offset
     * @param limit
     * @return
     */
    @Select("SELECT * FROM train_info LIMIT #{limit} OFFSET  #{offset}")
    List<TrainInfo> findTrainInfoByLimit(@Param("offset") int offset,@Param("limit") int limit);


    /**
     *
     * 根据车次查询列车
     * @param train_number
     * @return
     */
    @Select("SELECT * FROM train_info where train_number = #{train_number}")
    TrainInfo findTrainInfo(@Param("train_number") String train_number);



}
