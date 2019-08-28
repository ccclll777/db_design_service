package com.example.db_design_service.service;

import com.example.db_design_service.bean.AllOrder;
import com.example.db_design_service.bean.GetOrderList;
import com.example.db_design_service.bean.OrderList;
import com.example.db_design_service.dao.TrainTicketOrderDao;
import org.springframework.core.annotation.Order;
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
    public List<GetOrderList> getOrderList(String user_phone_number,  String train_no,  String start_no,  String end_no)
    {
//        return trainTicketOrderDao.GetOrderList(user_phone_number,datetime,train_no,start_no,end_no);
        return trainTicketOrderDao.GetOrderList(user_phone_number,train_no,start_no,end_no);
    }

    public void UpdateOrderPaySuccess(String order_id)
    {
        trainTicketOrderDao.UpdateOrderPaySuccess(order_id);
    }

    public String SelectPassengerType(String user_phone_number,String passenger_phone_number)
    {
        return trainTicketOrderDao.SelectPassengerType(user_phone_number,passenger_phone_number);
    }


    public List<OrderList> getOrderListByStartTime(String user_phone_number,String passenger_phone_number ,String train_start_date)
    {
        return trainTicketOrderDao.getOrderListByStartTime(user_phone_number,passenger_phone_number,train_start_date);
    }

    public List<AllOrder> getAllOrder()
    {
        return trainTicketOrderDao.getAllOrder();
    }

    public String getTrainStartTime(String train_no,String station_no)
    {
        return  trainTicketOrderDao.getTrainStartTime(train_no,station_no);
    }
}
