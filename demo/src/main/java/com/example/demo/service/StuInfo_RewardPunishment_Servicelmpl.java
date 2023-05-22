package com.example.demo.service;

import com.example.demo.dao.StuInfo_RewardPunishment_Mapper;
import com.example.demo.pojo.StuInfo_RewardPunishment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StuInfo_RewardPunishment_Servicelmpl implements StuInfo_RewardPunishment_Service {
    @Autowired
    StuInfo_RewardPunishment_Mapper stuInfo_rp_Mapper;

    @Override
    public List<StuInfo_RewardPunishment> findAll() {
        return stuInfo_rp_Mapper.findAll();
    }
}
