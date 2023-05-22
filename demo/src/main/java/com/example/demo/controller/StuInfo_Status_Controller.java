package com.example.demo.controller;


import com.example.demo.dao.StuInfo_Status_Mapper;
import com.example.demo.pojo.StuInfo_Status;
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
public class StuInfo_Status_Controller {
    @Autowired
    StuInfo_Status_Mapper stuStatusMapper;

    @RequestMapping ("/api/stuInfo/status")
    public List<StuInfo_Status> StuInfo_Status_Mapper(){
        List<StuInfo_Status> statuslists = stuStatusMapper.findAll();
        return statuslists;
    }
}

