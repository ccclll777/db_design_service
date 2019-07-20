package com.example.db_design_service.service;

import com.example.db_design_service.bean.GetAllOrderList;
import com.example.db_design_service.dao.OrderListDao;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderListService {


    @Resource
    private OrderListDao orderListDao;


    public List<GetAllOrderList> getAllOrderLists (String user_phone_number)
    {
        return orderListDao.GetAllOrderList(user_phone_number);
    }


    public List<GetAllOrderList> getNotripOrderLists (String user_phone_number)
    {
        return orderListDao.GetNotripOrderList(user_phone_number);
    }
    public List<GetAllOrderList> getNopayOrderLists (String user_phone_number)
    {
        return orderListDao.GetNopayOrderList(user_phone_number);
    }

}
