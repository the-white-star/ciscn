package com.example.demo.controller;


import com.example.demo.dao.StuInfo_ScoreList_Mapper;
import com.example.demo.pojo.StuInfo_ScoreList;
import com.example.demo.utils.StatusCode;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController         //注解可以使结果以Json字符串的形式返回给客户端
@CrossOrigin                //解决跨域问题
@RequestMapping(value = "/api/stuInfo")         //使链接还有一个 /api
public class StuInfo_ScoreList_Controller {
    @Autowired
    StuInfo_ScoreList_Mapper stuInfo_scoreList_mapper;

    @RequestMapping("scoreList")
    public Map<String, Object> StuInfo_ScoreList_Mapper() {
        int tmp = stuInfo_scoreList_mapper.isScoreList();
        if (tmp == 0) {
            return StatusCode.error(2001, "数据不存在");
        } else {
            List<StuInfo_ScoreList> scores = stuInfo_scoreList_mapper.findAll();
            return StatusCode.success(scores);
        }
    }
}

