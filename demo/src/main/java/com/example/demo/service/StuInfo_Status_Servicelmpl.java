package com.example.demo.service;

import com.example.demo.dao.StuInfo_Status_Mapper;
import com.example.demo.pojo.StuInfo_Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StuInfo_Status_Servicelmpl implements StuInfo_Status_Service {
    @Autowired
    StuInfo_Status_Mapper stuInfo_status_Mapper;

    @Override
    public List<StuInfo_Status> findAll() {
        return stuInfo_status_Mapper.findAll();
    }
}
