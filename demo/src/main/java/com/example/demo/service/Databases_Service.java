package com.example.demo.service;

import com.example.demo.pojo.Databases;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//数据库表结构
public interface Databases_Service {
    List<Databases> findAll();

    int isDatabases();
    /**
     * 功能:显示部分信息
     *
     * @param DBid 数据库的id
     * @return 返回对应的表信息
     */
    List<Databases> listtables(int DBid);

    /**
     * 功能:插入Databases数据到数据库
     *
     * @param  databases 对象
     * @return 是否插入成功
     */
    int insertDatabases(Databases databases);
}
