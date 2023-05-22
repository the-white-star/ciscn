package com.example.demo.service;

import com.example.demo.dao.Shopping_PayList_Mapper;
import com.example.demo.pojo.Shopping_PayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Shopping_PayList_Servicelmpl implements Shopping_PayList_Service {
    @Autowired
    Shopping_PayList_Mapper shopping_payList_Mapper;

    @Override
    public List<Shopping_PayList> findAll() {
        return shopping_payList_Mapper.findAll();
    }
}
