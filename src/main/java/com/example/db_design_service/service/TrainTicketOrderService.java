package com.example.db_design_service.service;

import com.example.db_design_service.bean.GetOrderList;
import com.example.db_design_service.bean.OrderList;
import com.example.db_design_service.dao.TrainTicketOrderDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TrainTicketOrderService {


    @Resource
    private TrainTicketOrderDao trainTicketOrderDao;
    public void addOrder(OrderList orderList)
    {
        trainTicketOrderDao.AddOrder(orderList);
    }
    public List<GetOrderList> getOrderList(String user_phone_number, String datetime, String train_no,  String start_no,  String end_no)
    {
        return trainTicketOrderDao.GetOrderList(user_phone_number,datetime,train_no,start_no,end_no);
    }

    public void UpdateOrderPaySuccess(String order_id)
    {
        trainTicketOrderDao.UpdateOrderPaySuccess(order_id);
    }


}
