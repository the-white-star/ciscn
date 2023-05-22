package com.example.demo.controller;


import com.example.demo.dao.Shopping_OrderList_Mapper;
import com.example.demo.pojo.Shopping_OrderList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController         //注解可以使结果以Json字符串的形式返回给客户端
public class Shopping_OrderList_Controller {
    @Autowired
    Shopping_OrderList_Mapper shopping_orderListMapper;

    @RequestMapping ("/api/shopping/orderList")
    public List<Shopping_OrderList> Shopping_OrderList_Mapper(){
        List<Shopping_OrderList> orderlists = shopping_orderListMapper.findAll();
        return orderlists;
    }
}

