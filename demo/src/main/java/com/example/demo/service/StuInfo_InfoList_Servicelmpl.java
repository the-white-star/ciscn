package com.example.demo.service;

import com.example.demo.dao.StuInfo_InfoList_Mapper;
import com.example.demo.pojo.StuInfo_InfoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StuInfo_InfoList_Servicelmpl implements StuInfo_InfoList_Service {
    @Autowired
    StuInfo_InfoList_Mapper stuInfo_infoList_Mapper;

    @Override
    public List<StuInfo_InfoList> findAll() {
        return stuInfo_infoList_Mapper.findAll();
    }
}
