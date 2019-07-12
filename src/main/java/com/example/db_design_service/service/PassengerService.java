package com.example.db_design_service.service;

import com.example.db_design_service.bean.PassengerInfo;
import com.example.db_design_service.dao.PassengerDao;
import com.example.db_design_service.dao.UserDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PassengerService {

    @Resource
    private PassengerDao passengerDao;
    public List<PassengerInfo>  selectPassenger(String user_phone_number)
    {
        return passengerDao.findPassenger(user_phone_number);
    }
    public void insertPassenger(String user_phone_number, String passenger_phone_number, String passenger_real_name, String passenger_id_number,int passenger_type, String passenger_address)
    {
        passengerDao.insertPassenger(user_phone_number,passenger_phone_number,passenger_real_name,passenger_id_number,passenger_type,passenger_address);
    }
    public void deletePassenger(String user_phone_number, String passenger_phone_number)
    {
        passengerDao.deletePassenger(user_phone_number,passenger_phone_number);
    }
}
