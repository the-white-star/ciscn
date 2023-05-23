package com.example.demo.dao;

import com.example.demo.pojo.Medical_Insurance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Medical_Insurance_Mapper {
    @Select("SELECT * FROM InsuranceInfo")
    List<Medical_Insurance> findAll();

    @Select("SELECT count(*) FROM InsuranceInfo")
    int isInsurance();

}