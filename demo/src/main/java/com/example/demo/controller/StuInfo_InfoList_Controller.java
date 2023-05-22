package com.example.demo.controller;


import com.example.demo.dao.StuInfo_InfoList_Mapper;
import com.example.demo.pojo.StuInfo_InfoList;
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
public class StuInfo_InfoList_Controller {
    @Autowired
    StuInfo_InfoList_Mapper stuInfoListMapper;

    @RequestMapping ("/api/stuInfo/infoList")
    public List<StuInfo_InfoList> StuInfo_InfoList_Mapper(){
        List<StuInfo_InfoList> infolists = stuInfoListMapper.findAll();
        return infolists;
    }
}

