package com.example.demo.dao;

import com.example.demo.pojo.StuInfo_Status;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StuInfo_Status_Mapper {
    @Select("SELECT * FROM StuInfo_StuStatus")
    List<StuInfo_Status> findAll();

    @Select("SELECT count(*) FROM StuInfo_StuStatus")
    int isStuStatus();

}