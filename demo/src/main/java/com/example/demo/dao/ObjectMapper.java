package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ObjectMapper {
    @Select("SELECT * FROM ${tableName}")
    List<Map<String, Object>> findAll(@Param("tableName") String tableName);
}
