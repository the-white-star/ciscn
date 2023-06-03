package com.example.demo.dao;

import com.example.demo.pojo.Medical_Insurance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Medical_Insurance_Mapper {
    @Select("SELECT * FROM Medical_InsuranceInfo")
    List<Medical_Insurance> findAll();

    @Select("SELECT count(*) FROM Medical_InsuranceInfo")
    int isInsurance();

}