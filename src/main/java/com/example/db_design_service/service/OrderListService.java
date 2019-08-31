package com.example.db_design_service.service;

import com.example.db_design_service.bean.AllOrder;
import com.example.db_design_service.bean.GetAllNoTripData;
import com.example.db_design_service.bean.GetAllOrderList;
import com.example.db_design_service.bean.GetOrderList;
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

    public void RefundTicket(String user_phone_number ,String order_id)
    {
        orderListDao.RefundTicket(user_phone_number,order_id);
    }

    public  void ChangeTicket(String passenger_phone_number,String order_id)
    {
        orderListDao.ChangeTicket(passenger_phone_number,order_id);
    }


    public List<GetOrderList> getOrderInof(String order_id)
    {
        return orderListDao.GetOrderInfo(order_id);
    }

    public List<GetOrderList> GetOrderChagngeList(String user_phone_number, String datetime, String train_no,  String start_no,  String end_no,String passenger_phone_number)
    {
        return orderListDao.GetOrderChagngeList(user_phone_number,datetime,train_no,start_no,end_no,passenger_phone_number);
    }
    public String getOrderMoney(String order_id)
    {
        return orderListDao.GetOrderMoney(order_id);
    }


    public List<GetAllOrderList> GetAllOrder()
    {
        return orderListDao.GetAllOrder();
    }

    public   void UpdateNoPayOrderStatus( int order_id)
    {
        orderListDao.UpdateNoPayOrderStatus(order_id);
    }
    public   void UpdatePayOrderStatus( String order_id)
    {
        orderListDao.UpdatePayOrderStatus(order_id);
    }

    public   List<GetAllNoTripData>  GetAllNoTripOrder()
    {
            return orderListDao.GetAllNoTripOrder();
    }
    public  List<AllOrder>  GetAllNoPayOrder()
    {
        return orderListDao.GetAllNoPayOrder();
    }

    public List<AllOrder> GetAllNoTripOrderByPassenger(String passenger_phone_number)
    {
        return orderListDao.GetAllNoTripOrderByPassenger(passenger_phone_number);
    }

}
