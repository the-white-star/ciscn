package com.example.demo.dao;

import com.example.demo.pojo.StuInfo_RewardPunishment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StuInfo_RewardPunishment_Mapper {
    @Select("SELECT * FROM Reward_Punishment")
    List<StuInfo_RewardPunishment> findAll();

    @Select("SELECT count(*) FROM Reward_Punishment")
    int isRP();

}