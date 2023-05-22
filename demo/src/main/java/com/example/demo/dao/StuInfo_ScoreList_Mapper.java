package com.example.demo.dao;

import com.example.demo.pojo.StuInfo_ScoreList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StuInfo_ScoreList_Mapper {
    @Select("SELECT * FROM ScoreList")
    List<StuInfo_ScoreList> findAll();
}