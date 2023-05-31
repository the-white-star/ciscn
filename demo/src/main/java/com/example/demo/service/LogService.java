package com.example.demo.service;

import com.example.demo.pojo.Log;

import java.util.List;

//日志
public interface LogService {

    /**
     * 功能:插入Log数据到数据库
     *
     * @param log 对象
     * @return 是否插入成功
     */
    int insertLog(Log log);

    /**
     * 功能:显示部分信息
     *
     * @param page 页数
     * @param limit 每页的条数
     * @return 返回每张页面的信息
     */
    List<Log> listLog(int page, int limit);

}
