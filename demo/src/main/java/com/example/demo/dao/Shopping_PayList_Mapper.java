package com.example.demo.dao;

import com.example.demo.pojo.Shopping_PayList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Shopping_PayList_Mapper {
    @Select("SELECT * FROM PayList")
    List<Shopping_PayList> findAll();

    @Select("SELECT count(*) FROM PayList")
    int isPayList();

}