package com.example.demo.service;

import com.example.demo.dao.Shopping_UserList_Mapper;
import com.example.demo.pojo.Shopping_UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Shopping_UserList_Servicelmpl implements Shopping_UserList_Service {
    @Autowired
    Shopping_UserList_Mapper shopping_userList_Mapper;

    @Override
    public List<Shopping_UserList> findAll() {
        return shopping_userList_Mapper.findAll();
    }
}
