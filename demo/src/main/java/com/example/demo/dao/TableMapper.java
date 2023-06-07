package com.example.demo.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;

@Mapper
public interface TableMapper {
    @UpdateProvider(type = SqlProvider.class, method = "createTable")
    void createTable(@Param("sql") String sql);

    class SqlProvider {
        public String createTable(@Param("sql") String sql) {
            return sql;
        }
    }
}