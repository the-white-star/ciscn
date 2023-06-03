package com.example.demo.dao;

import com.example.demo.pojo.Medical_MedicalList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Medical_MedicalList_Mapper {
    @Select("SELECT * FROM Medical_MedicalList")
    List<Medical_MedicalList> findAll();

    @Select("SELECT count(*) FROM Medical_MedicalList")
    int isMedicalList();

}