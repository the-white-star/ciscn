package com.example.demo.dao;

import com.example.demo.pojo.Shopping_UserList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Shopping_UserList_Mapper {
    @Select("SELECT * FROM Shopping_UserList")
    List<Shopping_UserList> findAll();

    @Select("SELECT count(*) FROM Shopping_UserList")
    int isUserList();

}