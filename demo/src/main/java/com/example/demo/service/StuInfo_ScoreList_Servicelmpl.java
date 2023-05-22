package com.example.demo.service;

import com.example.demo.dao.StuInfo_ScoreList_Mapper;
import com.example.demo.pojo.StuInfo_ScoreList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StuInfo_ScoreList_Servicelmpl implements StuInfo_ScoreList_Service {
    @Autowired
    StuInfo_ScoreList_Mapper stuInfo_scoreList_Mapper;

    @Override
    public List<StuInfo_ScoreList> findAll() {
        return stuInfo_scoreList_Mapper.findAll();
    }
}
