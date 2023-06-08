package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ObjectMapper {
    @Select("SELECT * FROM ${tablesname_en}")
    List<Map<String, Object>> findAll(@Param("tablesname_en") String tablesname_en);

    @Select("SELECT count(*) FROM ${tablesname_en}")
    int isobject(@Param("tablesname_en") String tablesname_en);
}
