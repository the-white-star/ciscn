package com.example.demo.dao;

import com.example.demo.pojo.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface AllTableMapper {
    /**
     * 查询所有表名
     */
    @Select("select table_name from information_schema.tables where table_schema = 'ciscn';")
    List<String> findAll();

    @Select("select count(table_name) from information_schema.tables where table_schema = 'ciscn';")
    int isAllTable();
}
