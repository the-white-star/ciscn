package com.example.demo.controller;


import com.example.demo.dao.StuInfo_RewardPunishment_Mapper;
import com.example.demo.pojo.StuInfo_RewardPunishment;
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
public class StuInfo_RewardPunishment_Controller {
    @Autowired
    StuInfo_RewardPunishment_Mapper sturpListMapper;

    @RequestMapping ("/api/stuInfo/rewardpunishment")
    public List<StuInfo_RewardPunishment> sturpListMapperMapper(){
        List<StuInfo_RewardPunishment> rp = sturpListMapper.findAll();
        return rp;
    }
}

