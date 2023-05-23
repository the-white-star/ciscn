package com.example.demo.dao;

import com.example.demo.pojo.Medical_PatientInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Medical_PatientInfo_Mapper {
    @Select("SELECT * FROM PatientInfo")
    List<Medical_PatientInfo> findAll();

    @Select("SELECT count(*) FROM PatientInfo")
    int isPatientInfo();

}