package com.example.demo.controller;


import com.example.demo.dao.Shopping_UserList_Mapper;
import com.example.demo.pojo.Shopping_UserList;
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
public class Shopping_UserList_Controller {
    @Autowired
    Shopping_UserList_Mapper shopping_userList_Mapper;

    @RequestMapping ("/api/shopping/userList")
    public List<Shopping_UserList> Shopping_UserList_Mapper(){
        List<Shopping_UserList> userlists = shopping_userList_Mapper.findAll();
        return userlists;
    }
}

