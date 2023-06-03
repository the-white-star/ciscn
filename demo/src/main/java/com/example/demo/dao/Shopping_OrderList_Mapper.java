package com.example.demo.dao;

import com.example.demo.pojo.Shopping_OrderList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Shopping_OrderList_Mapper {
    @Select("SELECT * FROM Shopping_OrderList")
    List<Shopping_OrderList> findAll();

    @Select("SELECT count(*) FROM Shopping_OrderList")
    int isOrderList();

}