package com.example.demo.controller;


import com.example.demo.dao.StuInfo_ScoreList_Mapper;
import com.example.demo.pojo.StuInfo_ScoreList;
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
public class StuInfo_ScoreList_Controller {
    @Autowired
    StuInfo_ScoreList_Mapper stuScoreListMapper;

    @RequestMapping ("/api/stuInfo/scoreList")
    public List<StuInfo_ScoreList> StuInfo_ScoreList_Mapper(){
        List<StuInfo_ScoreList> scorelists = stuScoreListMapper.findAll();
        return scorelists;
    }
}

