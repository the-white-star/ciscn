package com.example.demo.dao;

import com.example.demo.pojo.StuInfo_InfoList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StuInfo_InfoList_Mapper {
    @Select("SELECT * FROM StuInfoList")
    List<StuInfo_InfoList> findAll();

    @Select("SELECT count(*) FROM StuInfoList")
    int isInfoList();

}