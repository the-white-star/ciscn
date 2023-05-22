package com.example.demo.service;
import com.example.demo.pojo.StuInfo_RewardPunishment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuInfo_RewardPunishment_Service {
    List<StuInfo_RewardPunishment> findAll();
}
