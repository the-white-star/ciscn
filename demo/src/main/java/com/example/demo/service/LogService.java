package com.example.demo.service;

import com.example.demo.pojo.Log;

import java.util.List;

public interface LogService {

    int insertLog(Log log);

    /**
     * 功能:显示部分信息
     *
     * @param page 页数
     * @return 返回每张页面的信息
     */
    List<Log> listLog(int page, int limit);
}
