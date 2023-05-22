package com.example.demo.service;

import com.example.demo.dao.Shopping_OrderList_Mapper;
import com.example.demo.pojo.Shopping_OrderList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Shopping_OrderList_Servicelmpl implements Shopping_OrderList_Service {
    @Autowired
    Shopping_OrderList_Mapper shopping_orderList_Mapper;

    @Override
    public List<Shopping_OrderList> findAll() {
        return shopping_orderList_Mapper.findAll();
    }
}
