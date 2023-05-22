package com.example.demo.controller;


import com.example.demo.dao.Shopping_PayList_Mapper;
import com.example.demo.pojo.Shopping_PayList;
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
public class Shopping_PayList_Controller {
    @Autowired
    Shopping_PayList_Mapper shopping_payListMapper;

    @RequestMapping ("/api/shopping/payList")
    public List<Shopping_PayList> Shopping_PayList_Mapper(){
        List<Shopping_PayList> paylists = shopping_payListMapper.findAll();
        return paylists;
    }
}

